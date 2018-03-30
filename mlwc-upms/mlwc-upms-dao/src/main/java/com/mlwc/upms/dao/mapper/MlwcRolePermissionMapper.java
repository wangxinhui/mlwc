package com.mlwc.upms.dao.mapper;

import com.mlwc.upms.dao.model.MlwcRolePermission;
import com.mlwc.upms.dao.model.MlwcRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlwcRolePermissionMapper {
    long countByExample(MlwcRolePermissionExample example);

    int deleteByExample(MlwcRolePermissionExample example);

    int deleteByPrimaryKey(Integer rolePermissionId);

    int insert(MlwcRolePermission record);

    int insertSelective(MlwcRolePermission record);

    List<MlwcRolePermission> selectByExample(MlwcRolePermissionExample example);

    MlwcRolePermission selectByPrimaryKey(Integer rolePermissionId);

    int updateByExampleSelective(@Param("record") MlwcRolePermission record, @Param("example") MlwcRolePermissionExample example);

    int updateByExample(@Param("record") MlwcRolePermission record, @Param("example") MlwcRolePermissionExample example);

    int updateByPrimaryKeySelective(MlwcRolePermission record);

    int updateByPrimaryKey(MlwcRolePermission record);
}