package com.netease.assignment.service.impl;

import com.netease.assignment.dao.IChartDao;
import com.netease.assignment.dao.ITradeDao;
import com.netease.assignment.meta.Chart;
import com.netease.assignment.meta.ChartItem;
import com.netease.assignment.meta.TradeItem;
import com.netease.assignment.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Tank 需要同步chart
 */
@Service("chartService")
public class ChartServiceImpl implements ChartService {

    @Autowired
    private IChartDao chartDao;

    @Autowired
    private ITradeDao tradeDao;

    @Override
    public void addChartItem(ChartItem chartItem) {

        chartDao.addChartItem(chartItem);
        Chart.getChart().addChartItem(chartItem);
    }

    @Override
    public Map<Integer, ChartItem> getChartItems(Integer userId) {

        if (Chart.getChart().getChartItems().size() == 0) {
            List<ChartItem> list = chartDao.getChartItems(userId);
            for (ChartItem chartItem : list) {
                Chart.getChart().addChartItem(chartItem);
            }
        }

        return Chart.getChart().getChartItems();
    }

    @Override
    public void clearChart(Integer userId) {

        Iterator<ChartItem> it = Chart.getChart().getChartItems().values().iterator();
        ChartItem chartItem;
        // 从数据库清空
        while (it.hasNext()) {
            chartItem = it.next();
            chartDao.deleteChartItem(chartItem.getItemId());
        }
        // 从购物车清空
        Chart.getChart().clearChart();
    }

    @Override
    public void updateChartItem(ChartItem chartItem) {

        chartDao.updateChartItem(chartItem);
        Chart.getChart().updateChartItem(chartItem);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    @Override
    public void buyAll(Integer userId) {

        // 购物车为空
        if (Chart.getChart().getChartItems().size() == 0) {
            return;
        }

        // 添加物品到trade
        List<TradeItem> tis = new ArrayList<>();
        // 下单时间
        String dateTime =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        TradeItem ti;
        for (ChartItem chartItem : Chart.getChart().getChartItems().values()) {
            ti = new TradeItem();
            ti.setUserId(userId);
            ti.setItemId(chartItem.getItemId());
            ti.setPrice(chartItem.getPrice());
            ti.setCount(chartItem.getCount());
            ti.setTime(dateTime);

            tis.add(ti);
        }

        // 添加到交易历史数据库中
        tradeDao.addTradeItems(tis);

        // 从购物车中删除
        clearChart(userId);

    }

}
