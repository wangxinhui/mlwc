package com.mlwc.upms.rpc.service.impl;

import com.mlwc.common.annotation.BaseService;
import com.mlwc.common.base.BaseServiceImpl;
import com.mlwc.upms.dao.mapper.MlwcUserPersissionMapper;
import com.mlwc.upms.dao.model.MlwcUserPersission;
import com.mlwc.upms.dao.model.MlwcUserPersissionExample;
import com.mlwc.upms.rpc.api.MlwcUserPersissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* MlwcUserPersissionService实现
* Created by shuzheng on 2018/3/30.
*/
@Service
@Transactional
@BaseService
public class MlwcUserPersissionServiceImpl extends BaseServiceImpl<MlwcUserPersissionMapper, MlwcUserPersission, MlwcUserPersissionExample> implements MlwcUserPersissionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MlwcUserPersissionServiceImpl.class);

    @Autowired
    MlwcUserPersissionMapper mlwcUserPersissionMapper;

}