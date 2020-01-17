package com.gateway.server.constant;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 袁毅雄
 * @description
 * @date 2019/6/11
 */
public class UrlConstant {

    /**
     * 放行登陆 接口
     * 需要被登录拦截器拦截
     */
    public static final List<String> PASS_SERVLET_PATHS = new ArrayList<String>() {
        {
            //游客登录
            add("/user/api/v*/auth/tourist/**");
        }
    };


    /**
     * 初始化不需要被gateway拦截过滤的接口
     */
    public static final List<String> PASS_NO_AUTHS = new ArrayList<>();

    /**
     * 匹配查看路径是否匹配
     *
     * @param paths       路径
     * @param servletPath 请求的路径
     * @return true表示可以匹配上
     */
    public static boolean matchPath(List<String> paths, String servletPath) {
        PathMatcher pathMatcher = new AntPathMatcher();
        for (String passServletPath : paths) {
            //判断路径是否匹配
            boolean match = pathMatcher.matchStart(passServletPath, servletPath);
            if (match) {
                //如果有一个匹配的 就跳出
                return true;
            }
        }
        return false;
    }
}
