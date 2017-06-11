package com.module.service;

import com.module.pojo.*;

import java.util.List;

/**
 * Created by lenovo on 2017/6/10.
 */
public interface StockService  {
    Stock getStock(String stockId);
    List<Stock> getAllStocks();
    List<Report> getXLReports(String stockCode);
    List<Report> getTCReports(String stockId);
    List<News> getNews(String stockId, int page);
    List<News> getNotices(String stockId, int page);
    List<Discuss> getDiscusses(String stockId, int page, String sort);
    Bank getBank();
    List<Report> getBankReports(int i);
}
