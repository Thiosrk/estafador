package com.module.pojo;

/**【讨论】实体类
 *
 * Created by xuyafan on 2017/6/11.
 */
public class Discuss {

    private String title;
    private String description;
    private String datetime;
    private String username;
    private String userUrl;
    private String discussUrl;

    public Discuss(String title, String description, String datetime, String username, String userUrl, String discussUrl) {
        this.title = title;
        this.description = description;
        this.datetime = datetime;
        this.username = username;
        this.userUrl = userUrl;
        this.discussUrl = discussUrl;
    }

    @Override
    public String toString() {
        return "Discuss{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", datetime='" + datetime + '\'' +
                ", username='" + username + '\'' +
                ", userUrl='" + userUrl + '\'' +
                ", discussUrl='" + discussUrl + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getDiscussUrl() {
        return discussUrl;
    }

    public void setDiscussUrl(String discussUrl) {
        this.discussUrl = discussUrl;
    }
}
