package com.mlwc.upms.getway.exception;

/**
 * @Author: by simple on 2018/4/19.
 */
public class ExpiredTokenException extends MlwcException{
    public ExpiredTokenException() {
        super(401,"登录已过期");
    }
}
