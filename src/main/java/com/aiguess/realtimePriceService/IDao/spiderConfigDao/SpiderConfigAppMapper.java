package com.aiguess.realtimePriceService.IDao.spiderConfigDao;

import com.aiguess.realtimePriceService.entity.spiderConfig.SpiderConfigApp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SpiderConfigAppMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SpiderConfigApp record);

    int insertSelective(SpiderConfigApp record);

    SpiderConfigApp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SpiderConfigApp record);

    int updateByPrimaryKey(SpiderConfigApp record);
}