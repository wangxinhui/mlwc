package com.mlwc.upms.getway.interceptor;

import com.mlwc.common.rest.JsonResponse;
import com.mlwc.common.util.SendUtils;
import com.mlwc.upms.getway.annotation.Logical;
import com.mlwc.upms.getway.annotation.RequiresPermissions;
import com.mlwc.upms.getway.annotation.RequiresRoles;
import com.mlwc.upms.getway.auth.SysCache;
import com.mlwc.upms.getway.auth.UserRealm;
import com.mlwc.upms.getway.exception.ErrorTokenException;
import com.mlwc.upms.getway.exception.ExpiredTokenException;
import com.mlwc.upms.getway.exception.UnauthorizedException;
import com.mlwc.upms.getway.util.JwtSubject;
import io.jsonwebtoken.ExpiredJwtException;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/**
 * @Author: by simple on 2018/4/18.
 */
public class ApiInterceptor implements HandlerInterceptor {

    public ApiInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        String userId = null;
        String token = request.getHeader("token");
        if (token == null) {
            token = request.getParameter("token");
        }
        try {
            if (StringUtils.isBlank(token)) {
                SendUtils.sendJson(response,new JsonResponse().failure("300"));
                return false;
            }
            userId = JwtSubject.getInstance().parseToken(token).getSubject();
        } catch (ExpiredJwtException var1) {
            JwtSubject.getInstance().expireToken(userId, token);
            SendUtils.sendJson(response,new JsonResponse().failure("401"));
            var1.printStackTrace();
        } catch (ErrorTokenException e){
            e.printStackTrace();
            SendUtils.sendJson(response,new JsonResponse().failure("402"));
//          throw new ErrorTokenException();
            return false;
        } catch (Exception e) {
            SendUtils.sendJson(response,new JsonResponse().failure("402"));
            e.printStackTrace();
            return false;
        }

        if (!JwtSubject.getInstance().isValidToken(userId,token)){
            throw new ExpiredTokenException();
        }else {
            if (handler instanceof HandlerMethod){
                Method method = ((HandlerMethod) handler).getMethod();
                if (method != null && (!checkPermission(method, userId) && !checkRole(method, userId))) {
                    throw new UnauthorizedException();
                }
            }
        }

        request.setAttribute("userId",userId);
        return true;
    }

    private boolean checkPermission(Method method, String userId) {
        RequiresPermissions annotation = method.getAnnotation(RequiresPermissions.class);
        if (annotation==null){
            return true;
        }else {
            String[] requiresPermissions = annotation.value();
            Logical logical = annotation.logical();
            return JwtSubject.getInstance().hasPermission(userId, requiresPermissions, logical);
        }
    }

    private boolean checkRole(Method method,String userId) {
        RequiresRoles annotation = method.getAnnotation(RequiresRoles.class);
        if (annotation == null) {
            return true;
        } else {
            String[] requiresRoles = annotation.value();
            Logical logical = annotation.logical();
            return JwtSubject.getInstance().hasRole(userId, requiresRoles, logical);
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    public void setCache(SysCache cache) {
        JwtSubject.getInstance().setTkCache(cache);
    }

    public void setUserRealm(UserRealm userRealm) {
        JwtSubject.getInstance().setMlwcRealm(userRealm);
    }
}
