package com.module.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 银行行业实体类
 * Created by xuyafan on 2017/6/9.
 */
public class Bank {

    private String date;//日期

    /**
     * 行业的平均值信息
     */
    private String avg_totalValue;  //平均总市值
    private String avg_netAsset;    //平均净资产
    private String avg_netMargin;   //平均净利润
    private String avg_pe;          //平均市盈率
    private String avg_pb;          //平均市净率
    private String avg_gpr;         //平均毛利率
    private String avg_npr;         //平均净利率
    private String avg_roe;         //平均ROE

    private List<Report> reports =new ArrayList<Report>();

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public String getAvg_totalValue() {
        return avg_totalValue;
    }

    public void setAvg_totalValue(String avg_totalValue) {
        this.avg_totalValue = avg_totalValue;
    }

    public String getAvg_netAsset() {
        return avg_netAsset;
    }

    public void setAvg_netAsset(String avg_netAsset) {
        this.avg_netAsset = avg_netAsset;
    }

    public String getAvg_netMargin() {
        return avg_netMargin;
    }

    public void setAvg_netMargin(String avg_netMargin) {
        this.avg_netMargin = avg_netMargin;
    }

    public String getAvg_pe() {
        return avg_pe;
    }

    public void setAvg_pe(String avg_pe) {
        this.avg_pe = avg_pe;
    }

    public String getAvg_pb() {
        return avg_pb;
    }

    public void setAvg_pb(String avg_pb) {
        this.avg_pb = avg_pb;
    }

    public String getAvg_gpr() {
        return avg_gpr;
    }

    public void setAvg_gpr(String avg_gpr) {
        this.avg_gpr = avg_gpr;
    }

    public String getAvg_npr() {
        return avg_npr;
    }

    public void setAvg_npr(String avg_npr) {
        this.avg_npr = avg_npr;
    }

    public String getAvg_roe() {
        return avg_roe;
    }

    public void setAvg_roe(String avg_roe) {
        this.avg_roe = avg_roe;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "date='" + date + '\'' +
                ", avg_totalValue='" + avg_totalValue + '\'' +
                ", avg_netAsset='" + avg_netAsset + '\'' +
                ", avg_netMargin='" + avg_netMargin + '\'' +
                ", avg_pe='" + avg_pe + '\'' +
                ", avg_pb='" + avg_pb + '\'' +
                ", avg_gpr='" + avg_gpr + '\'' +
                ", avg_npr='" + avg_npr + '\'' +
                ", avg_roe='" + avg_roe + '\'' +
                ", reports=" + reports +
                '}';
    }
}
