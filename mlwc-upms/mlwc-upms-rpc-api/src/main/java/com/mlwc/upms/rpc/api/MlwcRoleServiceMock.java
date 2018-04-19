package com.mlwc.upms.rpc.api;

import com.mlwc.common.base.BaseServiceMock;
import com.mlwc.upms.dao.mapper.MlwcRoleMapper;
import com.mlwc.upms.dao.model.MlwcRole;
import com.mlwc.upms.dao.model.MlwcRoleExample;

import java.util.List;

/**
* 降级实现MlwcRoleService接口
* Created by shuzheng on 2018/3/30.
*/
public class MlwcRoleServiceMock extends BaseServiceMock<MlwcRoleMapper, MlwcRole, MlwcRoleExample> implements MlwcRoleService {

    @Override
    public List<MlwcRole> selectRolesByUserId(String userId) {
        return null;
    }
}
