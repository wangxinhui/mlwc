package com.mlwc.upms.getway.exception;

/**
 * @Author: by simple on 2018/4/19.
 */
public class UnauthorizedException extends MlwcException {

    public UnauthorizedException() {
        super(403, "没有访问权限");
    }
}
