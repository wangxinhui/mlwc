package com.mlwc.upms.rpc.api;

import com.mlwc.common.base.BaseServiceMock;
import com.mlwc.upms.dao.mapper.MlwcRolePermissionMapper;
import com.mlwc.upms.dao.model.MlwcRolePermission;
import com.mlwc.upms.dao.model.MlwcRolePermissionExample;

/**
* 降级实现MlwcRolePermissionService接口
* Created by shuzheng on 2018/3/30.
*/
public class MlwcRolePermissionServiceMock extends BaseServiceMock<MlwcRolePermissionMapper, MlwcRolePermission, MlwcRolePermissionExample> implements MlwcRolePermissionService {

}
