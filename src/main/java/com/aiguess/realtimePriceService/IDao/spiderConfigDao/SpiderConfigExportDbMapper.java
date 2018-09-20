package com.aiguess.realtimePriceService.IDao.spiderConfigDao;

import com.aiguess.realtimePriceService.entity.spiderConfig.SpiderConfigExportDb;
import com.aiguess.realtimePriceService.entity.spiderConfig.SpiderConfigFields;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SpiderConfigExportDbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SpiderConfigExportDb record);

    int insertSelective(SpiderConfigExportDb record);

    SpiderConfigExportDb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SpiderConfigExportDb record);

    int updateByPrimaryKey(SpiderConfigExportDb record);

    @Select("select *  from  spider_config_export_db where app_id=#{app_id}  limit 1")
    @Results({
            @Result(property="dbName",column="db_name"),
            @Result(property="tableName",column="table_name"),
            @Result(property="fieldMapping",column="field_mapping"),
    })
    SpiderConfigExportDb getExportDbByAppId(@Param("app_id") int app_id);
}