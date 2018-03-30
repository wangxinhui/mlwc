package com.mlwc.upms.rpc.service.impl;

import com.mlwc.common.annotation.BaseService;
import com.mlwc.common.base.BaseServiceImpl;
import com.mlwc.upms.dao.mapper.MlwcRolePermissionMapper;
import com.mlwc.upms.dao.model.MlwcRolePermission;
import com.mlwc.upms.dao.model.MlwcRolePermissionExample;
import com.mlwc.upms.rpc.api.MlwcRolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* MlwcRolePermissionService实现
* Created by shuzheng on 2018/3/30.
*/
@Service
@Transactional
@BaseService
public class MlwcRolePermissionServiceImpl extends BaseServiceImpl<MlwcRolePermissionMapper, MlwcRolePermission, MlwcRolePermissionExample> implements MlwcRolePermissionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MlwcRolePermissionServiceImpl.class);

    @Autowired
    MlwcRolePermissionMapper mlwcRolePermissionMapper;

}