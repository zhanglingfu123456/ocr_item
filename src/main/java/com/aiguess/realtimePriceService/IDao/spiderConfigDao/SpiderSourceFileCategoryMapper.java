package com.aiguess.realtimePriceService.IDao.spiderConfigDao;

import com.aiguess.realtimePriceService.entity.spiderConfig.SpiderSourceFileCategory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SpiderSourceFileCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SpiderSourceFileCategory record);

    int insertSelective(SpiderSourceFileCategory record);

    SpiderSourceFileCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SpiderSourceFileCategory record);

    int updateByPrimaryKey(SpiderSourceFileCategory record);
}