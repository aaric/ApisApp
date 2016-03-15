package cn.edu.znufe.dhf.apisapp.model;

import java.util.List;

/**
 * Created by Aaric on 2016/3/15.
 */
public class NewsMapObject {

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 状态信息
     */
    private String msg;
    /**
     * 数据
     */
    private List<NewsObject> newslist;

    public NewsMapObject() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewsObject> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewsObject> newslist) {
        this.newslist = newslist;
    }

}
