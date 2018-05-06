package cn.ehi.excel;

import cn.ehi.excel.controller.exception.ServiceException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;

@WebFilter(filterName = "ipFilter",urlPatterns = "/*")
public class IpFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(!Arrays.asList(new String[]{"127.0.0.1"}).contains(servletRequest.getRemoteAddr())){
            throw new ServiceException(403,"ip forbid");
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
