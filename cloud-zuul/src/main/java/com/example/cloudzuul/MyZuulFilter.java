package com.example.cloudzuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * zuul 的过滤器
 *
 */
@Slf4j
@Component
public class MyZuulFilter extends ZuulFilter {
    /**
     * 设置过滤器类型
     * pre 前置，在路由之前过滤，也就说在 请求到达真正的服务之前过滤
     * routing ： 路由之时
     * post ： 路由之后
     * error ： 发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否使用这个过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤逻辑处理
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                //相应客户端
                ctx.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {
            }
            return null;
        }
        log.info("ok");
        return null;
    }
}
