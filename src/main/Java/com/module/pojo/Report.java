package com.module.pojo;

/**
 * 研究报告实体类
 * Created by xuyafan on 2017/6/9.
 */
public class Report {
    private String stockId;//报告所属的股票（eg：sh6000000）或者是银行行业（eg：bank）

    private String title;// 标题
    private String date;  // 日期

    private String type; //评级类别

    private String org; //机构名称
    private String reporter;//研究员
    private String reportUrl; //研报正文链接



    /**
     * 研报正文显示的内容
     */

    private String mTitle;
    private String mDetail;
    private String mContent;


    public String printReportDetail() {
        return "Report{" +
                "mTitle='" + mTitle + '\'' +
                ", mDetail='" + mDetail + '\'' +
                ", mContent='" + mContent + '\'' +
                '}';
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDetail() {
        return mDetail;
    }

    public void setmDetail(String mDetail) {
        this.mDetail = mDetail;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
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
                ", mTitle='" + mTitle + '\'' +
                ", mDetail='" + mDetail + '\'' +
                ", mContent='" + mContent + '\'' +
                '}';
    }
}
