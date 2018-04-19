package com.mlwc.upms.getway.auth;

import com.mlwc.upms.dao.model.MlwcPermission;
import com.mlwc.upms.dao.model.MlwcRole;
import com.mlwc.upms.getway.interceptor.MlwcRealm;
import com.mlwc.upms.getway.util.JwtSubject;
import com.mlwc.upms.rpc.api.MlwcPermissionService;
import com.mlwc.upms.rpc.api.MlwcRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @Author: by simple on 2018/4/18.
 */
public class UserRealm extends MlwcRealm {

    @Autowired
    private MlwcRoleService mlwcRoleService;

    @Autowired
    private MlwcPermissionService mlwcPermissionService;

    @Override
    public Map<String, Set<String>> getRoles(String userId) {
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> roleNames = new HashSet<>();
        Set<String> roleIds = new HashSet<>();
        List<MlwcRole> mlwcRoles = mlwcRoleService.selectRolesByUserId(userId);
        for (int i = 0; i < mlwcRoles.size(); i++) {
            roleIds.add(mlwcRoles.get(i).getRoleId().toString());
            roleNames.add(mlwcRoles.get(i).getName());
        }
        map.put("roleNames", roleNames);
        map.put("roleIds", roleIds);
        return map;
    }

    @Override
    public Set<String> getPermissions(String userId) {
        Set<String> permissionsValues = new HashSet<>();
        List<String> roleIds = JwtSubject.getInstance().getUserRoles(userId);
        if (roleIds.size() > 0) {
            List<MlwcPermission> permissions = mlwcPermissionService.selectPermissionsByRoleId(roleIds);
            for (int i = 0; i < permissions.size(); i++) {
                String permissionValue = permissions.get(i).getPermissionValue();
                permissionsValues.add(permissionValue);
            }
        }
        return permissionsValues;
    }
}
