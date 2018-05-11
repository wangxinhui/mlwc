package com.mlwc.upms.server.controller;

import com.mlwc.common.rest.JsonResponse;
import com.mlwc.upms.dao.model.MlwcUser;
import com.mlwc.upms.dao.model.MlwcUserExample;
import com.mlwc.upms.rpc.api.MlwcUserService;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

@Controller
//@Api(value = "user manager" ,description = "user manager")
@RequestMapping("/api/user")
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

    @RequestMapping("/getAllUsers")
    @ResponseBody
    public JsonResponse getAllUsers(
            @RequestParam(required = true,value = "cont") Integer cont,
            @RequestParam(required = true,value = "pages") Integer pages) {
        MlwcUserExample mlwcUserExample = new MlwcUserExample();
        List<MlwcUser> mlwcUsers = mlwcUserService.selectByExample(mlwcUserExample);
        return new JsonResponse().success(mlwcUsers);

    }
}
