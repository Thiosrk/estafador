package com.module.pojo;

/**
 * 研究报告实体类
 * Created by xuyafan on 2017/6/9.
 */
public class Report {
    private String stockId;//报告所属的股票（eg：sh6000000）或者是银行行业（eg：bank）

    private String title;// 标题
    private String date;  // 日期

    private String type; //报告类型：公司报告，行业报告

    private String org; //机构名称
    private String reporter;//研究员
    private String reportUrl; //研报正文链接


    public Report(String stockId, String title, String date, String type, String org, String reporter, String reportUrl) {
        this.stockId = stockId;
        this.title = title;
        this.date = date;
        this.type = type;
        this.org = org;
        this.reporter = reporter;
        this.reportUrl = reportUrl;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getReportUrl() {
        return reportUrl;
    }

    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl;
    }

    @Override
    public String toString() {
        return "Report{" +
                "stockId='" + stockId + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", org='" + org + '\'' +
                ", reporter='" + reporter + '\'' +
                ", reportUrl='" + reportUrl + '\'' +
                '}';
    }
}
