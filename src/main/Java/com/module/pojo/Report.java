package com.module.pojo;

/**
 * 研究报告实体类
 * Created by xuyafan on 2017/6/9.
 */
public class Report {
    private String id;//序号
    private String title;// 标题
    private String date;  // 日期
    private String rateType; //评级类别
    private String rateChange; //评级变动
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getRateChange() {
        return rateChange;
    }

    public void setRateChange(String rateChange) {
        this.rateChange = rateChange;
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
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", rateType='" + rateType + '\'' +
                ", rateChange='" + rateChange + '\'' +
                ", org='" + org + '\'' +
                ", reporter='" + reporter + '\'' +
                ", reportUrl='" + reportUrl + '\'' +
                '}';
    }


}
