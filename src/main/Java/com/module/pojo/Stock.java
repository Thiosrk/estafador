package com.module.pojo;


import java.util.ArrayList;
import java.util.List;

/**
 * Stock 实体类，用于实例存储网页数据，数据库需要什么拿什么
 * Created by xuyafan on 2017/6/8.
 */
public class Stock {


    /**
     * 股票基本信息,通过 printBasicInfo()打印
     */
    private String id; //股票代码

    private String name; //名称

    private String price;  //最新价

    private String upStaying; //涨停

    private String fallStaying; //跌停

    private String change; //涨跌额

    private String changeP; //涨跌幅

    private String close; //昨收

    private String open;  //今开

    private String high; //最高

    private String low; //最低

    private String tradeVol; //成交量/手

    private String tradeAmount; //成交额/万

    private String totalValue; //总市值

    private String freeValue; //流通市值

    private String tr;//换手率

    private String pb;//市净率

    private String pe;//市盈率

    private String qr;//量比

    private String datetime; //日期时间

    private String netAsset; //净资产

    private String netMargin; //净利润

    private String gpr; //毛利率

    private String npr; //净利率

    private String roe;  //就是ROE

    /**
     * 股票在行业中的排名信息,通过 printRankInfo()打印
     */
    private String rank_totalValue; //总市值排名
    private String rank_netAsset;   //净资产排名
    private String rank_netMargin;  //净利润排名
    private String rank_pe;     //市盈率排名
    private String rank_pb;     //市净率排名
    private String rank_gpr;    //毛利率排名
    private String rank_npr;     //净利率排名
    private String rank_roe;    //ROE排名

    private List<Report> reports =new ArrayList<Report>();

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }



    // for new Stock()
    public Stock() {
    }

    public Stock(String id, String name, String price, String upStaying,
                 String fallStaying, String change, String changeP, String close, String open,
                 String high, String low, String tradeVol, String tradeAmount,
                 String totalValue, String freeValue,
                 String tr, String pb, String pe, String qr, String datetime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.upStaying = upStaying;
        this.fallStaying = fallStaying;
        this.change = change;
        this.changeP = changeP;
        this.close = close;
        this.open = open;
        this.high = high;
        this.low = low;
        this.tradeVol = tradeVol;
        this.tradeAmount = tradeAmount;
        this.totalValue = totalValue;
        this.freeValue = freeValue;
        this.tr = tr;
        this.pb = pb;
        this.pe = pe;
        this.qr = qr;
        this.datetime = datetime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUpStaying() {
        return upStaying;
    }

    public void setUpStaying(String upStaying) {
        this.upStaying = upStaying;
    }

    public String getFallStaying() {
        return fallStaying;
    }

    public void setFallStaying(String fallStaying) {
        this.fallStaying = fallStaying;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getChangeP() {
        return changeP;
    }

    public void setChangeP(String changeP) {
        this.changeP = changeP;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getTradeVol() {
        return tradeVol;
    }

    public void setTradeVol(String tradeVol) {
        this.tradeVol = tradeVol;
    }

    public String getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(String tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public String getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(String totalValue) {
        this.totalValue = totalValue;
    }

    public String getFreeValue() {
        return freeValue;
    }

    public void setFreeValue(String freeValue) {
        this.freeValue = freeValue;
    }

    public String getTr() {
        return tr;
    }

    public void setTr(String tr) {
        this.tr = tr;
    }

    public String getPb() {
        return pb;
    }

    public void setPb(String pb) {
        this.pb = pb;
    }

    public String getPe() {
        return pe;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getNetAsset() {
        return netAsset;
    }

    public void setNetAsset(String netAsset) {
        this.netAsset = netAsset;
    }

    public String getNetMargin() {
        return netMargin;
    }

    public void setNetMargin(String netMargin) {
        this.netMargin = netMargin;
    }

    public String getGpr() {
        return gpr;
    }

    public void setGpr(String gpr) {
        this.gpr = gpr;
    }

    public String getNpr() {
        return npr;
    }

    public void setNpr(String npr) {
        this.npr = npr;
    }

    public String getRoe() {
        return roe;
    }

    public void setRoe(String roe) {
        this.roe = roe;
    }

    public String getRank_totalValue() {
        return rank_totalValue;
    }

    public void setRank_totalValue(String rank_totalValue) {
        this.rank_totalValue = rank_totalValue;
    }

    public String getRank_netAsset() {
        return rank_netAsset;
    }

    public void setRank_netAsset(String rank_netAsset) {
        this.rank_netAsset = rank_netAsset;
    }

    public String getRank_netMargin() {
        return rank_netMargin;
    }

    public void setRank_netMargin(String rank_netMargin) {
        this.rank_netMargin = rank_netMargin;
    }

    public String getRank_pe() {
        return rank_pe;
    }

    public void setRank_pe(String rank_pe) {
        this.rank_pe = rank_pe;
    }

    public String getRank_pb() {
        return rank_pb;
    }

    public void setRank_pb(String rank_pb) {
        this.rank_pb = rank_pb;
    }

    public String getRank_gpr() {
        return rank_gpr;
    }

    public void setRank_gpr(String rank_gpr) {
        this.rank_gpr = rank_gpr;
    }

    public String getRank_npr() {
        return rank_npr;
    }

    public void setRank_npr(String rank_npr) {
        this.rank_npr = rank_npr;
    }

    public String getRank_roe() {
        return rank_roe;
    }

    public void setRank_roe(String rank_roe) {
        this.rank_roe = rank_roe;
    }

    public String printBasicInfo(){
        return "Stock{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", upStaying='" + upStaying + '\'' +
                ", fallStaying='" + fallStaying + '\'' +
                ", change='" + change + '\'' +
                ", changeP='" + changeP + '\'' +
                ", close='" + close + '\'' +
                ", open='" + open + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", tradeVol='" + tradeVol + '\'' +
                ", tradeAmount='" + tradeAmount + '\'' +
                ", totalValue='" + totalValue + '\'' +
                ", freeValue='" + freeValue + '\'' +
                ", tr='" + tr + '\'' +
                ", pb='" + pb + '\'' +
                ", pe='" + pe + '\'' +
                ", qr='" + qr + '\'' +
                ", datetime='" + datetime + '\'' +
                ", netAsset='" + netAsset + '\'' +
                ", netMargin='" + netMargin + '\'' +
                ", gpr='" + gpr + '\'' +
                ", npr='" + npr + '\'' +
                ", roe='" + roe + '\'' +
                '}';
    }


    public String printRankInfo() {
        return "Stock{" +
                "rank_totalValue='" + rank_totalValue + '\'' +
                ", rank_netAsset='" + rank_netAsset + '\'' +
                ", rank_netMargin='" + rank_netMargin + '\'' +
                ", rank_pe='" + rank_pe + '\'' +
                ", rank_pb='" + rank_pb + '\'' +
                ", rank_gpr='" + rank_gpr + '\'' +
                ", rank_npr='" + rank_npr + '\'' +
                ", rank_roe='" + rank_roe + '\'' +
                '}';
    }
}
