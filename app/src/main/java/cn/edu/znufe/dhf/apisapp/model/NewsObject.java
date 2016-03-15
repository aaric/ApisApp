package cn.edu.znufe.dhf.apisapp.model;

/**
 * Created by Aaric on 2016/3/15.
 */
public class NewsObject {

    /**
     * 发布时间
     */
    private String ctime;
    /**
     * 新闻标题
     */
    private String title;
    /**
     * 新闻简介
     */
    private String description;
    /**
     * 图片路径
     */
    private String picUrl;
    /**
     * 详情地址
     */
    private String url;

    public NewsObject() {
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
