package com.mlwc.upms.server.controller;

import com.mlwc.common.rest.JsonResponse;
import com.mlwc.common.util.DateUtil;
import com.mlwc.upms.dao.model.MlwcUser;
import com.mlwc.upms.dao.model.MlwcUserExample;
import com.mlwc.upms.getway.util.JwtSubject;
import com.mlwc.upms.rpc.api.MlwcUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: by simple on 2018/4/16.
 */

@Controller
@RequestMapping("/api")
public class SSOController {

    @Autowired
    private MlwcUserService mlwcUserService;

    @RequestMapping("/login")
    @ResponseBody
    public JsonResponse login(
            @RequestParam(required = false, value = "username") String username,
            @RequestParam(required = false, value = "password") String password) throws IOException {
        MlwcUserExample mlwcUserExample = new MlwcUserExample();
        if (StringUtils.isBlank(username)) {
            return new JsonResponse().failure("401");
        }
        if (StringUtils.isBlank(password)) {
            return new JsonResponse().failure("401");
        }
        mlwcUserExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
//        mlwcUserExample.createCriteria().andPasswordEqualTo(password);
        MlwcUser mlwcUser = mlwcUserService.selectFirstByExample(mlwcUserExample);
        if (mlwcUser == null) {
            return new JsonResponse().failure();
        }
        String token = JwtSubject.getInstance().createToken(mlwcUser.getUserId().toString(), DateUtil.getAppointDate(new Date(), 30));
        mlwcUser.setPassword("");
        Map<String, Object> map = new HashMap<>();
        map.put("user", mlwcUser);
        map.put("token", token);
        return new JsonResponse().success(map);
    }

}
