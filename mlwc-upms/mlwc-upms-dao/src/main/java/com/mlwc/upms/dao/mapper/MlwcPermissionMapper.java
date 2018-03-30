package com.mlwc.upms.dao.mapper;

import com.mlwc.upms.dao.model.MlwcPermission;
import com.mlwc.upms.dao.model.MlwcPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlwcPermissionMapper {
    long countByExample(MlwcPermissionExample example);

    int deleteByExample(MlwcPermissionExample example);

    int deleteByPrimaryKey(Integer permissionId);

    int insert(MlwcPermission record);

    int insertSelective(MlwcPermission record);

    List<MlwcPermission> selectByExample(MlwcPermissionExample example);

    MlwcPermission selectByPrimaryKey(Integer permissionId);

    int updateByExampleSelective(@Param("record") MlwcPermission record, @Param("example") MlwcPermissionExample example);

    int updateByExample(@Param("record") MlwcPermission record, @Param("example") MlwcPermissionExample example);

    int updateByPrimaryKeySelective(MlwcPermission record);

    int updateByPrimaryKey(MlwcPermission record);
}