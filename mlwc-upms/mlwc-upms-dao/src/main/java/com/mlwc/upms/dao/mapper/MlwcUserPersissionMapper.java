package com.mlwc.upms.dao.mapper;

import com.mlwc.upms.dao.model.MlwcUserPersission;
import com.mlwc.upms.dao.model.MlwcUserPersissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlwcUserPersissionMapper {
    long countByExample(MlwcUserPersissionExample example);

    int deleteByExample(MlwcUserPersissionExample example);

    int deleteByPrimaryKey(Integer userPersissionId);

    int insert(MlwcUserPersission record);

    int insertSelective(MlwcUserPersission record);

    List<MlwcUserPersission> selectByExample(MlwcUserPersissionExample example);

    MlwcUserPersission selectByPrimaryKey(Integer userPersissionId);

    int updateByExampleSelective(@Param("record") MlwcUserPersission record, @Param("example") MlwcUserPersissionExample example);

    int updateByExample(@Param("record") MlwcUserPersission record, @Param("example") MlwcUserPersissionExample example);

    int updateByPrimaryKeySelective(MlwcUserPersission record);

    int updateByPrimaryKey(MlwcUserPersission record);
}