package com.mlwc.upms.rpc.service.impl;

import com.mlwc.common.annotation.BaseService;
import com.mlwc.common.base.BaseServiceImpl;
import com.mlwc.upms.dao.mapper.MlwcRoleMapper;
import com.mlwc.upms.dao.model.MlwcRole;
import com.mlwc.upms.dao.model.MlwcRoleExample;
import com.mlwc.upms.rpc.api.MlwcRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* MlwcRoleService实现
* Created by shuzheng on 2018/3/30.
*/
@Service
@Transactional
@BaseService
public class MlwcRoleServiceImpl extends BaseServiceImpl<MlwcRoleMapper, MlwcRole, MlwcRoleExample> implements MlwcRoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MlwcRoleServiceImpl.class);

    @Autowired
    MlwcRoleMapper mlwcRoleMapper;


    @Override
    public List<MlwcRole> selectRolesByUserId(String userId) {
        return mlwcRoleMapper.selectRolesByUserId(userId);
    }
}