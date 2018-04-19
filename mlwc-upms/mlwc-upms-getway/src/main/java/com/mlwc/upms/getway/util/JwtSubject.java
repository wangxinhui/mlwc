package com.mlwc.upms.getway.util;

import com.mlwc.common.util.TokenUtil;
import com.mlwc.upms.getway.annotation.Logical;
import com.mlwc.upms.getway.interceptor.MlwcRealm;
import com.mlwc.upms.getway.interceptor.TkCache;
import io.jsonwebtoken.Claims;

import java.util.*;

/**
 * @Author: by simple on 2018/4/18.
 * 获取
 */
public class JwtSubject {

    //promission key header
    private static final String MLWC_PRE_PS = "mlwcps-";
    //roles key header
    private static final String MLWC_PRE_RS = "mlwcrs-";
    //roles name header
    private static final String MLWC_PRE_RS_NAME = "mlwcrsname-";
    //token
    private static final String MLWC_PRE_TOKEN = "mlwctk-";

    private MlwcRealm mlwcRealm;

    private TkCache tkCache;

    private static String tokenKey = "m-l-w-c";



    private JwtSubject(){
    }
    private static class HolderClass{
        private final static JwtSubject instance = new JwtSubject();
    }

    public static JwtSubject getInstance(){
        return HolderClass.instance;
    }

    public MlwcRealm getMlwcRealm() {
        return mlwcRealm;
    }

    public void setMlwcRealm(MlwcRealm mlwcRealm) {
        this.mlwcRealm = mlwcRealm;
    }

    public TkCache getTkCache() {
        return tkCache;
    }

    public void setTkCache(TkCache tkCache) {
        this.tkCache = tkCache;
    }

    public static String getTokenKey() {
        return tokenKey;
    }

    public static void setTokenKey(String tokenKey) {
        JwtSubject.tokenKey = tokenKey;
    }

    public boolean hasRole(String userId, String[] roles, Logical logical){
        this.checkUserRealm();
        boolean result = false;
        List<String> cacheRoles = this.getUserRoleNames(userId);

        for (int i = 0; i < roles.length; i++) {
            result = cacheRoles.contains(roles[i]);
            if (logical==(result?Logical.OR:Logical.AND)){
                break;
            }
        }
        return result;
    }

    public boolean hasRole(String userId, String role){
        return this.hasRole(userId,new String[]{role},Logical.OR);
    }

    public boolean hasPermission(String userId, String[] permissions, Logical logical) {
        this.checkUserRealm();
        boolean result = false;
        List<String> cachePermissions = this.getUserPermissions(userId);
        for (int i = 0; i < cachePermissions.size(); i++) {
            result = cachePermissions.contains(permissions[i]);
            if (logical == (result ? Logical.OR : Logical.AND)) {
                break;
            }
        }
        return result;
    }

    public boolean hasPermission(String userId, String permission ) {
        return hasPermission(userId, new String[]{permission}, Logical.OR);
    }


    public List<String> getUserPermissions(String userId) {
        List<String> cachePermissions = tkCache.getSet(MLWC_PRE_PS + userId);
        if(cachePermissions == null || cachePermissions.size() == 0) {
            cachePermissions = new ArrayList();
            Set<String> userPermissions = mlwcRealm.getPermissions(userId);
            if(userPermissions != null && userPermissions.size() > 0) {
                ((List)cachePermissions).addAll(userPermissions);
                tkCache.putSet(MLWC_PRE_PS + userId, userPermissions);
            }
        }
        return (List)cachePermissions;
    }



    public List<String> getUserRoles(String userId){
        List<String> cacheRoles = tkCache.getSet(MLWC_PRE_RS + userId);
        if (cacheRoles == null || cacheRoles.size() == 0) {
            cacheRoles = new ArrayList<>();
            Set<String> userRoles = mlwcRealm.getRoles(userId).get("roleIds");
            if (userRoles != null && userRoles.size() > 0) {
                cacheRoles.addAll(userRoles);
                tkCache.putSet(MLWC_PRE_RS + userId,userRoles);
            }
        }
        return cacheRoles;
    }

    public List<String> getUserRoleNames(String userId){
        List<String> cacheRoles = tkCache.getSet(MLWC_PRE_RS_NAME + userId);
        if (cacheRoles == null || cacheRoles.size() == 0) {
            cacheRoles = new ArrayList<>();
            Set<String> userRoles = mlwcRealm.getRoles(userId).get("roleNames");
            if (userRoles != null && userRoles.size() > 0) {
                cacheRoles.addAll(userRoles);
                tkCache.putSet(MLWC_PRE_RS_NAME + userId,userRoles);
            }
        }
        return cacheRoles;
    }

    private void checkUserRealm(){
        if (mlwcRealm==null){
            throw  new NullPointerException("mlwcReaml is null!");
        }
    }

    public boolean updateCachePermission(String userId) {
        this.checkUserRealm();
        return tkCache.delete(MLWC_PRE_PS + userId);
    }

    public boolean updateCachePermission() {
        this.checkUserRealm();
        return tkCache.delete(tkCache.keys(MLWC_PRE_PS + "*"));
    }

    public boolean updateCacheRoles(String userId) {
        this.checkUserRealm();
        return tkCache.delete(MLWC_PRE_RS + userId);
    }

    public boolean updateCacheRoles() {
        this.checkUserRealm();
        return tkCache.delete(tkCache.keys(MLWC_PRE_RS + "*"));
    }

    public boolean isValidToken(String userId, String token) {
        this.checkUserRealm();
        List<String> tokens = tkCache.getSet(MLWC_PRE_TOKEN + userId);
        return tokens != null && tokens.contains(token);
    }

    private boolean setCacheToken(String userId, String token) {
        this.checkUserRealm();
        if(mlwcRealm.isSingUser()) {
            tkCache.delete(MLWC_PRE_TOKEN + userId);
        }

        Set<String> tokens = new HashSet();
        tokens.add(token);
        return tkCache.putSet(MLWC_PRE_TOKEN + userId, tokens);
    }

    public boolean expireToken(String userId) {
        return tkCache.delete(MLWC_PRE_TOKEN + userId);
    }

    public boolean expireToken(String userId, String token) {
        return tkCache.removeSet(MLWC_PRE_TOKEN + userId, token);
    }

    public String createToken(String userId, Date expireDate) {
        String token = TokenUtil.createToken(userId, tokenKey, expireDate);
        this.setCacheToken(userId, token);
        return token;
    }

    public Claims parseToken(String token) throws Exception {
        return TokenUtil.parseToken(token, tokenKey);
    }

}
