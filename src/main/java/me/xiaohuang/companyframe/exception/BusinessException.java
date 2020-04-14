package me.xiaohuang.companyframe.exception;

import me.xiaohuang.companyframe.exception.code.BaseResponseCode;

/**
 * @ClassName BusinessException
 * @Description BusinessException
 * @Author xiaohuang
 * @Date 2020/4/6 20:47
 * @Version 1.0
 */
public class BusinessException extends RuntimeException{
    /**
     *  异常 code
     */
    private final int code;

    /**
     *  异常提示
     */
    public final String defaultMessage;

    public BusinessException(int code, String defaultMessage) {
        super(defaultMessage);
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

    public BusinessException(BaseResponseCode baseResponseCode){
        this(baseResponseCode.getCode(), baseResponseCode.getMsg());
    }

    public int getCode() {
        return code;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}
