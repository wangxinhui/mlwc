package com.mlwc.upms.getway.auth;

import com.mlwc.common.util.RedisUtil;
import com.mlwc.upms.getway.interceptor.TkCache;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @Author: by simple on 2018/4/18.
 */
public class SysCache extends TkCache {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<String> getSet(String var1) {
        return redisUtil.lRange(var1,0,-1);
    }

    @Override
    public boolean putSet(String var1, Set<String> var2) {
        return redisUtil.lLeftPushAll(var1,var2) > 0;
    }

    @Override
    public boolean removeSet(String var1, String var2) {
        return redisUtil.lRemove(var1,0,var2) > 0;
    }

    @Override
    public boolean delete(String var1)
    {
        redisUtil.delete(var1);
        return true;
    }

    @Override
    public boolean delete(Collection<String> var1) {
        redisUtil.delete(var1);
        return true;
    }

    @Override
    public Set<String> keys(String var1) {
        return redisUtil.keys(var1);
    }
}
