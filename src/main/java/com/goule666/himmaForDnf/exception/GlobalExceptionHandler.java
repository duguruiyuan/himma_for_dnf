package com.goule666.himmaForDnf.exception;


import com.goule666.himmaForDnf.enums.ResponseInfo;
import com.goule666.himmaForDnf.model.Reply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by niewenlong-work on 2017/5/23.
 */
//定义统一的异常处理类
@ControllerAdvice
class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * bean校验未通过异常
     *
     * @see javax.validation.Valid
     * @see org.springframework.validation.Validator
     * @see org.springframework.validation.DataBinder
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public Reply<List<FieldError>> validExceptionHandler(BindException e, WebRequest request, HttpServletResponse response) {
        List<FieldError> fieldErrors=e.getBindingResult().getFieldErrors();
        for (FieldError error:fieldErrors){
            logger.error(error.getField()+":"+error.getDefaultMessage());
        }
        return new Reply<>(fieldErrors, ResponseInfo.INVALID_REQUEST.getState());
    }


}
