package com.mlwc.upms.rpc.service.impl;

import com.alibaba.dubbo.common.json.JSON;
import com.mlwc.common.annotation.BaseService;
import com.mlwc.common.base.BaseServiceImpl;
import com.mlwc.common.db.DataSourceEnum;
import com.mlwc.common.db.DynamicDataSource;
import com.mlwc.upms.dao.mapper.MlwcPermissionMapper;
import com.mlwc.upms.dao.model.MlwcMenu;
import com.mlwc.upms.dao.model.MlwcPermission;
import com.mlwc.upms.dao.model.MlwcPermissionExample;
import com.mlwc.upms.rpc.api.MlwcPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<MlwcPermission> selectPermissionsByRoleId(List<String> roleIds) {
        return mlwcPermissionMapper.selectPermissionsByRoleId(roleIds);
    }

    @Override
    public String selectPermissionsByUserId(Integer userId) {

        DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
        List<MlwcPermission> mlwcPermissions = mlwcPermissionMapper.selectPermissionsByUserId(userId);
        Map<Integer, MlwcMenu> map = new HashMap<>();
        for (int i = 0; i < mlwcPermissions.size();i++){
                MlwcMenu mlwcMenu = new MlwcMenu();
                mlwcMenu.setTitle(mlwcPermissions.get(i).getName());
                mlwcMenu.setIcon("");
                mlwcMenu.setHref(mlwcPermissions.get(i).getUri());
                mlwcMenu.setSpread(false);
                if (mlwcPermissions.get(i).getPid().equals(0)){
                    map.put(mlwcPermissions.get(i).getPermissionId(),mlwcMenu);
                }else {
                    if (map.containsKey(mlwcPermissions.get(i).getPid())) {
                        MlwcMenu mlwcMenu1 = map.get(mlwcPermissions.get(i).getPid());
                        List l = mlwcMenu1.getChildren();
                        if (l==null){
                            l = new ArrayList();
                        }
                        l.add(mlwcMenu);
                        mlwcMenu1.setChildren(l);
                        map.put(mlwcPermissions.get(i).getPid(), mlwcMenu1);
                    }
                }
        }
        try {
            List<MlwcMenu> list = new ArrayList<>();
            for (Map.Entry entry : map.entrySet()){
                list.add((MlwcMenu) entry.getValue());
            }
            return JSON.json(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}