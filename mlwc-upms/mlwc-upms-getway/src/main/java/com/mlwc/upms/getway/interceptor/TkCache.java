package com.mlwc.upms.getway.interceptor;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @Author: by simple on 2018/4/18.
 * 抽象缓存token
 *
 */
public abstract class TkCache {
    public TkCache() {
    }

    public abstract List<String> getSet(String var1);

    public abstract boolean putSet(String var1, Set<String> var2);

    public abstract boolean removeSet(String var1, String var2);

    public abstract boolean delete(String var1);

    public abstract boolean delete(Collection<String> var1);

    public abstract Set<String> keys(String var1);

}
