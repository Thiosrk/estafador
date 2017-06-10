package com.module.service;

import com.module.pojo.Bank;
import com.module.pojo.Report;
import com.module.pojo.Stock;

import java.util.List;

/**
 * Created by lenovo on 2017/6/10.
 */
public interface StockService  {
    Stock getStock(String stockId);
    List<Stock> getAllStocks();
    List<Report> getXLReports(String stockCode);
    List<Report> getTCReports(String stockId);
    Bank getBank();
    List<Report> getBankReports(int i);
}
