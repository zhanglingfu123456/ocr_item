package com.aiguess.realtimePriceService.IDao.spiderConfigDao;

import com.aiguess.realtimePriceService.entity.spiderConfig.SpStockMetricCN;

public interface SpStockMetricCNMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SpStockMetricCN record);

    int insertSelective(SpStockMetricCN record);

    SpStockMetricCN selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SpStockMetricCN record);

    int updateByPrimaryKey(SpStockMetricCN record);
}