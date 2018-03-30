package com.mlwc.upms.rpc.service.impl;

import com.mlwc.common.annotation.BaseService;
import com.mlwc.common.base.BaseServiceImpl;
import com.mlwc.upms.dao.mapper.MlwcPermissionMapper;
import com.mlwc.upms.dao.model.MlwcPermission;
import com.mlwc.upms.dao.model.MlwcPermissionExample;
import com.mlwc.upms.rpc.api.MlwcPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* MlwcPermissionService实现
* Created by shuzheng on 2018/3/30.
*/
@Service
@Transactional
@BaseService
public class MlwcPermissionServiceImpl extends BaseServiceImpl<MlwcPermissionMapper, MlwcPermission, MlwcPermissionExample> implements MlwcPermissionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MlwcPermissionServiceImpl.class);

    @Autowired
    MlwcPermissionMapper mlwcPermissionMapper;

}