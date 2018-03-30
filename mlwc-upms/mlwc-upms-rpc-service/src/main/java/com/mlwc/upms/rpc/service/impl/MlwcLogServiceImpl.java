package com.mlwc.upms.rpc.service.impl;

import com.mlwc.common.annotation.BaseService;
import com.mlwc.common.base.BaseServiceImpl;
import com.mlwc.upms.dao.mapper.MlwcLogMapper;
import com.mlwc.upms.dao.model.MlwcLog;
import com.mlwc.upms.dao.model.MlwcLogExample;
import com.mlwc.upms.rpc.api.MlwcLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* MlwcLogService实现
* Created by shuzheng on 2018/3/30.
*/
@Service
@Transactional
@BaseService
public class MlwcLogServiceImpl extends BaseServiceImpl<MlwcLogMapper, MlwcLog, MlwcLogExample> implements MlwcLogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MlwcLogServiceImpl.class);

    @Autowired
    MlwcLogMapper mlwcLogMapper;

}