package com.pactera.learn.spring.common;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class RequestTimingFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) {
//    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        try {
            chain.doFilter(request, response);
        } finally {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            System.out.println(String.format("%s %s took %d ms", httpRequest.getMethod(), httpRequest.getRequestURI(), duration));
        }
    }

    @Override
    public void destroy() {
    }
}
