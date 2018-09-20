package com.aiguess.realtimePriceService.IDao.spiderConfigDao;

import com.aiguess.realtimePriceService.entity.spiderConfig.SpiderConfigExportDb;
import com.aiguess.realtimePriceService.entity.spiderConfig.SpiderUrlRecord;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SpiderUrlRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpiderUrlRecord record);

    int insertSelective(SpiderUrlRecord record);

    SpiderUrlRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpiderUrlRecord record);

    int updateByPrimaryKey(SpiderUrlRecord record);

    @Select("select id, url, params, url_params_md5, create_time, update_time, is_delete  from  spider_url_record where url_params_md5=#{url_params_md5}  limit 1")
    @Results({
            @Result(property="urlParamsMd5",column="url_params_md5"),
            @Result(property="isDelete",column="is_delete"),
            @Result(property="updateTime",column="update_time"),
    })
    SpiderUrlRecord getUrlRecord(@Param("url_params_md5") String url_params_md5);
}