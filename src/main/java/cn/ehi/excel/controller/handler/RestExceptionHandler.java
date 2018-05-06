package cn.ehi.excel.controller.handler;

import cn.ehi.excel.controller.ResponseResult;
import cn.ehi.excel.controller.RestResultGenerator;
import cn.ehi.excel.controller.annotation.ErrorCode;
import cn.ehi.excel.controller.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

@ControllerAdvice
public class RestExceptionHandler{

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    private <T> ResponseResult<T> serviceExceptionHandler(ServiceException e) {
        LOGGER.error("业务异常: CODE:{}, MSG:{}", e.getCode(), e.getMessage());
        return RestResultGenerator.genError(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    private <T> ResponseResult<T> bindExceptionHandler(BindException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        fieldErrors.forEach(err -> LOGGER.error("参数异常: CODE:{}, MSG:{}", ErrorCode.ILLEGAL_PARAMS, err.getField() + " ==> " + err.getDefaultMessage()));
        return RestResultGenerator.genError(ErrorCode.BAD_REQUEST, fieldErrors.get(0).getDefaultMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    private <T> ResponseResult<T> noHandlerFoundExceptionHandler(NoHandlerFoundException e) {
        LOGGER.error("地址异常: CODE:{}, MSG:{}", ErrorCode.PAGE_NOT_FOUND, e.getRequestURL()+"["+e.getHttpMethod()+"]");
        return RestResultGenerator.genError(ErrorCode.PAGE_NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    private <T> ResponseResult<T> exceptionHandler(Exception e) {
        LOGGER.error("程序异常: MSG:{}",e.getMessage());
        return RestResultGenerator.genError(ErrorCode.SERVER_ERROR, e.getMessage());
    }
}
