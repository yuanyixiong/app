package com.gateway.server.filters;

import com.alibaba.fastjson.JSONObject;
import com.gateway.server.bean.LoginAndRegisterResult;
import com.gateway.server.config.swagger.SwaggerProvider;
import com.gateway.server.constant.LoginUserConstant;
import com.gateway.server.constant.UrlConstant;
import com.gateway.server.excetions.AuthFailException;
import com.gateway.server.excetions.ShareLoseEfficacyException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.Optional;

/**
 * @author 袁毅雄
 * @description 请求校验Token
 * @date 2019/6/11
 */
@Component
public class TokenFilter implements GlobalFilter, Ordered {


    @Autowired
    private ValueOperations valueOperations;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest req = exchange.getRequest();
        String path = req.getURI().getRawPath();
        if (UrlConstant.matchPath(UrlConstant.PASS_SERVLET_PATHS, path) || UrlConstant.matchPath(UrlConstant.PASS_NO_AUTHS, path)
                || path.endsWith(SwaggerProvider.API_URI)) {
            return chain.filter(exchange);
        }

        final String token = exchange.getRequest().getHeaders().getFirst(LoginUserConstant.APP_USER_INFO_KEY);

        if (StringUtils.isBlank(token)) {
            throw new AuthFailException();
        }

        if (LoginUserConstant.SHARE_APP_USER_INFO_KEY.equals(token)) {

            MultiValueMap<String, String> requestParam = exchange.getRequest().getQueryParams();

            String userId = requestParam.get("share_userId").get(0);

            if (Objects.isNull(valueOperations.get(String.format("%s_%s", LoginUserConstant.RESOURCE_SHARE, userId)))) {
                throw new ShareLoseEfficacyException();
            }

            ServerHttpRequest request = exchange.getRequest().mutate().header("loginUserId", userId).build();

            return chain.filter(exchange.mutate().request(request).build());
        }

        final String jsonStr = Optional.ofNullable(valueOperations.get(token)).map(Object::toString).orElseThrow(() -> new AuthFailException());

        LoginAndRegisterResult user = JSONObject.parseObject(jsonStr, LoginAndRegisterResult.class);

        final String userId = Optional.ofNullable(user.getId()).orElseThrow(() -> new AuthFailException());

        ServerHttpRequest request = exchange.getRequest().mutate()
                .header("loginUserId", userId).build();

        return chain.filter(exchange.mutate().request(request).build());

    }

    @Override
    public int getOrder() {
        return -9;
    }

}
