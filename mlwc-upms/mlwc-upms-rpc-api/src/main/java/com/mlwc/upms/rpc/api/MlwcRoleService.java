package com.mlwc.upms.rpc.api;

import com.mlwc.common.base.BaseService;
import com.mlwc.upms.dao.model.MlwcRole;
import com.mlwc.upms.dao.model.MlwcRoleExample;

import java.util.List;

/**
* MlwcRoleService接口
* Created by shuzheng on 2018/3/30.
*/
public interface MlwcRoleService extends BaseService<MlwcRole, MlwcRoleExample> {

    List<MlwcRole> selectRolesByUserId(String userId);
}