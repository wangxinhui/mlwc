package com.mlwc.upms.rpc.service.impl;

import com.mlwc.common.annotation.BaseService;
import com.mlwc.common.base.BaseServiceImpl;
import com.mlwc.upms.dao.mapper.MlwcUserRoleMapper;
import com.mlwc.upms.dao.model.MlwcUserRole;
import com.mlwc.upms.dao.model.MlwcUserRoleExample;
import com.mlwc.upms.rpc.api.MlwcUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* MlwcUserRoleService实现
* Created by shuzheng on 2018/3/30.
*/
@Service
@Transactional
@BaseService
public class MlwcUserRoleServiceImpl extends BaseServiceImpl<MlwcUserRoleMapper, MlwcUserRole, MlwcUserRoleExample> implements MlwcUserRoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MlwcUserRoleServiceImpl.class);

    @Autowired
    MlwcUserRoleMapper mlwcUserRoleMapper;

}