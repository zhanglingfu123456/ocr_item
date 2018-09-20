package com.aiguess.realtimePriceService.IDao.spiderConfigDao;

import com.aiguess.realtimePriceService.entity.spiderConfig.SpiderConfigFields;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SpiderConfigFieldsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SpiderConfigFields record);

    int insertSelective(SpiderConfigFields record);

    SpiderConfigFields selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SpiderConfigFields record);

    int updateByPrimaryKey(SpiderConfigFields record);

    //根据app_id拿到所有的
    @Select("select *  from  spider_config_fields where app_id=#{app_id}")
    @Results({
            @Result(property="fieldName",column="field_name"),
            @Result(property="isDelete",column="is_delete")
    })
    List<SpiderConfigFields> getFieldsByAppId(@Param("app_id") int app_id);
}