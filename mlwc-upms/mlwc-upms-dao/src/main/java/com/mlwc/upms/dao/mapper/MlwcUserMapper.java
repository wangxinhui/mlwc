package com.mlwc.upms.dao.mapper;

import com.mlwc.upms.dao.model.MlwcUser;
import com.mlwc.upms.dao.model.MlwcUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlwcUserMapper {
    long countByExample(MlwcUserExample example);

    int deleteByExample(MlwcUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(MlwcUser record);

    int insertSelective(MlwcUser record);

    List<MlwcUser> selectByExample(MlwcUserExample example);

    MlwcUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") MlwcUser record, @Param("example") MlwcUserExample example);

    int updateByExample(@Param("record") MlwcUser record, @Param("example") MlwcUserExample example);

    int updateByPrimaryKeySelective(MlwcUser record);

    int updateByPrimaryKey(MlwcUser record);
}