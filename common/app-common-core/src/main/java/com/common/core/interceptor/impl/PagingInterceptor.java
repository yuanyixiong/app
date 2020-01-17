package com.common.core.interceptor.impl;

import com.common.core.interceptor.AbstractInterceptor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;


/**
 * @author 袁毅雄
 * @description 分页请求拦截器
 * @date 2019/6/11
 */
@Component
public class PagingInterceptor extends AbstractInterceptor {

    @Override
    public String interceptorPath() {
        return "/**";
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final Integer page = Optional.ofNullable(request.getParameter("page")).map(Integer::valueOf).orElse(null);
        final Integer limit = Optional.ofNullable(request.getParameter("limit")).map(Integer::valueOf).orElse(null);
        request.setAttribute("page", page);
        request.setAttribute("limit", limit);
        return true;
    }
}
