package com.mlwc.upms.dao.mapper;

import com.mlwc.upms.dao.model.MlwcUserRole;
import com.mlwc.upms.dao.model.MlwcUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlwcUserRoleMapper {
    long countByExample(MlwcUserRoleExample example);

    int deleteByExample(MlwcUserRoleExample example);

    int deleteByPrimaryKey(Integer userRoleId);

    int insert(MlwcUserRole record);

    int insertSelective(MlwcUserRole record);

    List<MlwcUserRole> selectByExample(MlwcUserRoleExample example);

    MlwcUserRole selectByPrimaryKey(Integer userRoleId);

    int updateByExampleSelective(@Param("record") MlwcUserRole record, @Param("example") MlwcUserRoleExample example);

    int updateByExample(@Param("record") MlwcUserRole record, @Param("example") MlwcUserRoleExample example);

    int updateByPrimaryKeySelective(MlwcUserRole record);

    int updateByPrimaryKey(MlwcUserRole record);
}