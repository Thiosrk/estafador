package com.module.service.Impl;

import com.module.pojo.Bank;
import com.module.pojo.Report;
import com.module.pojo.Stock;
import com.module.service.StockService;
import com.spider.Spider;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2017/6/10.
 */
@Service
public class StockServiceImpl implements StockService{
    Spider spider=new Spider();
    @Override
    public Stock getStock(String stockId) {
        return spider.getStock(stockId);
    }

    @Override
    public List<Stock> getAllStocks() {
        return spider.getAllStocks();
    }

    @Override
    public List<Report> getXLReports(String stockCode) {
        return spider.getXLReports(stockCode);
    }

    @Override
    public List<Report> getTCReports(String stockId) {
        return spider.getTCReports(stockId);
    }

    @Override
    public Bank getBank() {
        return spider.getBank();
    }

    @Override
    public List<Report> getBankReports(int i) {
        return spider.getBankReports(i);
    }
}
