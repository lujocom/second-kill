package com.xcalculas.study.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * <dl>
 * <dt>second-kill</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2015</dd>
 * <dd>Company: 成都微积分科技有限公司</dd>
 * <dd>CreateDate: 2017年04月25日</dd>
 * </dl>
 *
 * @author LuoHui
 */
public class XssFilter implements Filter {
    protected transient final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        logger.debug("-------XssFilter-------start");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        logger.debug("-------XssFilter--url : {}", httpServletRequest.getServletPath());
        XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper(httpServletRequest);
        filterChain.doFilter(xssRequest, response);
        logger.debug("-------XssFilter-------end");
    }

    @Override
    public void destroy() {

    }
}
