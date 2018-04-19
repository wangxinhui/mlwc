package com.mlwc.upms.getway.interceptor;

import java.util.Map;
import java.util.Set;

/**
 * @Author: by simple on 2018/4/18.
 */
public abstract class MlwcRealm {
    public MlwcRealm() {
    }
    public abstract Map<String,Set<String>> getRoles(String var1);

    public abstract Set<String> getPermissions(String var1);

    public boolean isSingUser(){
        return false;
    }
}
