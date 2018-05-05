package com.mlwc.upms.server.controller;

import com.mlwc.common.rest.JsonResponse;
import com.mlwc.upms.dao.model.MlwcUser;
import com.mlwc.upms.rpc.api.MlwcUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@Api(value = "user manager" ,description = "user manager")
@RequestMapping("/user")
public class MlwcUserController {

    @Autowired
    private MlwcUserService mlwcUserService;
    @RequestMapping("/getUsers/{id}")
    @ResponseBody
    public JsonResponse getUsers(@PathVariable("id") int id){
        MlwcUser mlwcUser = mlwcUserService.selectByPrimaryKey(id);
        if (mlwcUser.getUserId() == null) {
            return new JsonResponse().failure("用户信息不存在");
        }
        return new JsonResponse().success(mlwcUser);
    }
}
