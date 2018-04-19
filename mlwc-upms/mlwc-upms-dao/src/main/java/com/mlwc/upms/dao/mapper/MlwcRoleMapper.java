package com.mlwc.upms.dao.mapper;

import com.mlwc.upms.dao.model.MlwcRole;
import com.mlwc.upms.dao.model.MlwcRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlwcRoleMapper {
    long countByExample(MlwcRoleExample example);

    int deleteByExample(MlwcRoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(MlwcRole record);

    int insertSelective(MlwcRole record);

    List<MlwcRole> selectByExample(MlwcRoleExample example);

    MlwcRole selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") MlwcRole record, @Param("example") MlwcRoleExample example);

    int updateByExample(@Param("record") MlwcRole record, @Param("example") MlwcRoleExample example);

    int updateByPrimaryKeySelective(MlwcRole record);

    int updateByPrimaryKey(MlwcRole record);

    List<MlwcRole> selectRolesByUserId(String userId);
}