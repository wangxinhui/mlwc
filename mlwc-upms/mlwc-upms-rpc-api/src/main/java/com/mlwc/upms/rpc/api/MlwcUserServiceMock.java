package com.mlwc.upms.rpc.api;

import com.mlwc.common.base.BaseServiceMock;
import com.mlwc.upms.dao.mapper.MlwcUserMapper;
import com.mlwc.upms.dao.model.MlwcUser;
import com.mlwc.upms.dao.model.MlwcUserExample;

/**
* 降级实现MlwcUserService接口
* Created by shuzheng on 2018/3/30.
*/
public class MlwcUserServiceMock extends BaseServiceMock<MlwcUserMapper, MlwcUser, MlwcUserExample> implements MlwcUserService {

}
