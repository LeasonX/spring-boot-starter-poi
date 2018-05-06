package cn.ehi.excel;

import cn.ehi.excel.controller.exception.ServiceException;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new HandlerInterceptorAdapter() {
//            @Override
//            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
////                throw new ServiceException(500,"ok");
//                return true;
//            }
//        }).excludePathPatterns("/druid/**")
//                .excludePathPatterns("/swagger-resources/**").excludePathPatterns("/v2/**")
//                .excludePathPatterns("/login").excludePathPatterns("/");
//    }
}
