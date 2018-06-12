package com.mlwc.upms.server.controller;

import com.mlwc.common.rest.JsonResponse;
import com.mlwc.upms.rpc.api.MlwcPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: by simple on 2018/5/4.
 */
@Controller
@RequestMapping("/api/permission")
public class MlwcPermissionController {

    @Autowired
    private MlwcPermissionService mlwcPermissionService;

    @RequestMapping("/getPermissionList")
    @ResponseBody
    public JsonResponse getPermissionList(HttpServletRequest request){
        String userId = (String) request.getAttribute("userId");
        String menus = mlwcPermissionService.selectPermissionsByUserId(Integer.valueOf(userId));
        return new JsonResponse().success(menus);
    }
}
