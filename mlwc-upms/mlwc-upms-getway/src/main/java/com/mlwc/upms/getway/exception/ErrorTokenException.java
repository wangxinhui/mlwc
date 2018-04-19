package com.mlwc.upms.getway.exception;

/**
 * @Author: by simple on 2018/4/19.
 */
public class ErrorTokenException extends MlwcException{
    public ErrorTokenException() {
        super(401, "身份验证失败");
    }
}
