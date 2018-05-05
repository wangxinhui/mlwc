package com.mlwc.upms.rpc.api;

import com.mlwc.common.base.BaseService;
import com.mlwc.upms.dao.model.MlwcPermission;
import com.mlwc.upms.dao.model.MlwcPermissionExample;

import java.util.List;

/**
* MlwcPermissionService接口
* Created by shuzheng on 2018/3/30.
*/
public interface MlwcPermissionService extends BaseService<MlwcPermission, MlwcPermissionExample> {

    List<MlwcPermission> selectPermissionsByRoleId(List<String> roleIds);

    String selectPermissionsByUserId(Integer userId);
}