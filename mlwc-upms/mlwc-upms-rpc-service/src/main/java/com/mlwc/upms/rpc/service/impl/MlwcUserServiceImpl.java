package com.mlwc.upms.rpc.service.impl;

import com.mlwc.common.annotation.BaseService;
import com.mlwc.common.base.BaseServiceImpl;
import com.mlwc.upms.dao.mapper.MlwcUserMapper;
import com.mlwc.upms.dao.model.MlwcUser;
import com.mlwc.upms.dao.model.MlwcUserExample;
import com.mlwc.upms.rpc.api.MlwcUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* MlwcUserService实现
* Created by shuzheng on 2018/3/30.
*/
@Service
@Transactional
@BaseService
public class MlwcUserServiceImpl extends BaseServiceImpl<MlwcUserMapper, MlwcUser, MlwcUserExample> implements MlwcUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MlwcUserServiceImpl.class);

    @Autowired
    MlwcUserMapper mlwcUserMapper;

}