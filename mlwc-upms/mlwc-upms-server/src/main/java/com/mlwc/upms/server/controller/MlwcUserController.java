package com.mlwc.upms.server.controller;

import com.mlwc.common.rest.JsonResponse;
import com.mlwc.upms.dao.model.MlwcUser;
import com.mlwc.upms.dao.model.MlwcUserExample;
import com.mlwc.upms.rpc.api.MlwcUserService;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@Api(value = "user manager" ,description = "user manager")
@RequestMapping("/api/user")
public class MlwcUserController {

    @Autowired
    private MlwcUserService mlwcUserService;

    @RequestMapping("/getUsers/{id}")
    @ResponseBody
    public JsonResponse getUsers(@PathVariable("id") int id) {
        MlwcUser mlwcUser = mlwcUserService.selectByPrimaryKey(id);
        if (mlwcUser.getUserId() == null) {
            return new JsonResponse().failure("用户信息不存在");
        }
        return new JsonResponse().success(mlwcUser);
    }

    @RequestMapping("/getAllUsers")
    @ResponseBody
    public JsonResponse getAllUsers(
            @RequestParam(required = true, value = "cont") Integer cont,
            @RequestParam(required = true, value = "pages") Integer pages, HttpServletRequest request) {
        MlwcUserExample mlwcUserExample = new MlwcUserExample();
        String username = request.getParameter("username");
        if (StringUtils.isNotBlank(username)) {
            mlwcUserExample.createCriteria().andUsernameLike(username);
        }

        List<MlwcUser> mlwcUsers = mlwcUserService.selectByExampleForStartPage(mlwcUserExample, pages, cont);
        int count = mlwcUserService.countByExample(mlwcUserExample);
        Map map = new HashMap();
        map.put("users", mlwcUsers);
        map.put("count", count);
        return new JsonResponse().success(map);

    }

    @RequestMapping("/save")
    @ResponseBody
    public JsonResponse saveUser(@ModelAttribute MlwcUser mlwcUser) {
        int res;
        if (mlwcUser.getUserId() > 0) {
            res = mlwcUserService.updateByPrimaryKey(mlwcUser);
        } else {
            res = mlwcUserService.insert(mlwcUser);
        }
        if (res > 0) {
            return new JsonResponse().success();
        }
        return new JsonResponse().failure();
    }

}
