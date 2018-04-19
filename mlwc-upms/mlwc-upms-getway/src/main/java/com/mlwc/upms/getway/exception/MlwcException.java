package com.mlwc.upms.getway.exception;

/**
 * @Author: by simple on 2018/4/19.
 */
public abstract class MlwcException extends RuntimeException {
    private static final long serialVersionUID = 2413958299445359501L;

    private int code ;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public MlwcException(int code,String message){
        super(message);
        this.code = code;
    }
}
