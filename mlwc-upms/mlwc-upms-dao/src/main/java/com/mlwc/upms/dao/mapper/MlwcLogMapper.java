package com.mlwc.upms.dao.mapper;

import com.mlwc.upms.dao.model.MlwcLog;
import com.mlwc.upms.dao.model.MlwcLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlwcLogMapper {
    long countByExample(MlwcLogExample example);

    int deleteByExample(MlwcLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(MlwcLog record);

    int insertSelective(MlwcLog record);

    List<MlwcLog> selectByExampleWithBLOBs(MlwcLogExample example);

    List<MlwcLog> selectByExample(MlwcLogExample example);

    MlwcLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") MlwcLog record, @Param("example") MlwcLogExample example);

    int updateByExampleWithBLOBs(@Param("record") MlwcLog record, @Param("example") MlwcLogExample example);

    int updateByExample(@Param("record") MlwcLog record, @Param("example") MlwcLogExample example);

    int updateByPrimaryKeySelective(MlwcLog record);

    int updateByPrimaryKeyWithBLOBs(MlwcLog record);

    int updateByPrimaryKey(MlwcLog record);
}