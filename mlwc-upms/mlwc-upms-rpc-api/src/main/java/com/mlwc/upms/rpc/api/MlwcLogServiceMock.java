package com.mlwc.upms.rpc.api;

import com.mlwc.common.base.BaseServiceMock;
import com.mlwc.upms.dao.mapper.MlwcLogMapper;
import com.mlwc.upms.dao.model.MlwcLog;
import com.mlwc.upms.dao.model.MlwcLogExample;

/**
* 降级实现MlwcLogService接口
* Created by shuzheng on 2018/3/30.
*/
public class MlwcLogServiceMock extends BaseServiceMock<MlwcLogMapper, MlwcLog, MlwcLogExample> implements MlwcLogService {

}
