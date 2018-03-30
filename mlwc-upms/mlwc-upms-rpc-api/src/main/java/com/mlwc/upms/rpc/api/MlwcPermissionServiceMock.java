package com.mlwc.upms.rpc.api;

import com.mlwc.common.base.BaseServiceMock;
import com.mlwc.upms.dao.mapper.MlwcPermissionMapper;
import com.mlwc.upms.dao.model.MlwcPermission;
import com.mlwc.upms.dao.model.MlwcPermissionExample;

/**
* 降级实现MlwcPermissionService接口
* Created by shuzheng on 2018/3/30.
*/
public class MlwcPermissionServiceMock extends BaseServiceMock<MlwcPermissionMapper, MlwcPermission, MlwcPermissionExample> implements MlwcPermissionService {

}
