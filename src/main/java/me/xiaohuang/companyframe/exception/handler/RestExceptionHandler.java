package me.xiaohuang.companyframe.exception.handler;

import lombok.extern.slf4j.Slf4j;
import me.xiaohuang.companyframe.exception.BusinessException;
import me.xiaohuang.companyframe.exception.code.BaseResponseCode;
import me.xiaohuang.companyframe.utils.DataResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @ClassName RestExceptionHandler
 * @Description RestExceptionHandler
 * @Author xiaohuang
 * @Date 2020/4/8 9:10
 * @Version 1.0
 */
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(value=Exception.class)
    public DataResult exception(Exception e) {
        log.error("Exception,{}", e.getLocalizedMessage());
        e.printStackTrace();
        return DataResult.getResult(BaseResponseCode.SYSTEM_ERROR);
    }

    @ExceptionHandler(value= BusinessException.class)
    public DataResult businessException(BusinessException e) {
        log.error("BusinessException,exception:{}", e);
        return new DataResult(e.getCode(), e.getDefaultMessage());
    }
     @ExceptionHandler(value = MethodArgumentNotValidException.class)
     <T> DataResult<T> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {

         log.error("methodArgumentNotValidExceptionHandler bindingResult.allErrors():{},exception:{}", e.getBindingResult().getAllErrors(), e);
         List<ObjectError> errors = e.getBindingResult().getAllErrors();
         return createValidExceptionResp(errors);
     }

    private <T> DataResult<T> createValidExceptionResp(List<ObjectError> errors) {
        String[] msgs = new String[errors.size()];
        int i = 0;
        for (ObjectError error : errors) {
            msgs[i] = error.getDefaultMessage();
            log.info("msg={}",msgs[i]);
            i++;
        }
        return DataResult.getResult(BaseResponseCode.METHOD_IDENTITY_ERROR.getCode(), msgs[0]);
    }
}
