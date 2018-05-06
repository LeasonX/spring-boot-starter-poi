package cn.ehi.excel.controller;

import cn.ehi.excel.controller.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class FilterExceptionController extends BasicErrorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilterExceptionController.class);

    public FilterExceptionController(){
        super(new DefaultErrorAttributes(),new ErrorProperties());
    }

    @GetMapping
    private <T> ResponseResult<T> serviceExceptionHandler(HttpServletRequest request) {
        Map<String,Object> body= getErrorAttributes(request,isIncludeStackTrace(request,MediaType.ALL));
        String message = String.valueOf(body.get("message"));
        body.forEach((k,v)->LOGGER.info("{} ==> {}",k,v));
        return RestResultGenerator.genError(500,"Filter Error Occurred, Message: [ "+message+" ]");
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}