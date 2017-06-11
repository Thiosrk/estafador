package com.module.pojo;

/**新闻和公告
 * https://gupiao.baidu.com/stock/sh600015.html
 * Created by xuyafan on 2017/6/11.
 */
public class News {
    private String title;
    private String intro;//介绍中含有超链接文字

    private String datetime;

    public News(String title, String intro, String datetime) {
        this.title = title;
        this.intro = intro;
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", intro='" + intro + '\'' +
                ", datetime='" + datetime + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }


    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
