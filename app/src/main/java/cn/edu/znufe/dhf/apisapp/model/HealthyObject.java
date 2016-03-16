package cn.edu.znufe.dhf.apisapp.model;

/**
 * Created by Aaric on 2016/3/16.
 */
public class HealthyObject {

    private Integer id;
    private Integer infoclass;
    private String title;
    private String description;
    private String keywords;
    private String img;
    private Integer count;
    private Integer fcount;
    private Integer rcount;
    private Long time;

    public HealthyObject() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInfoclass() {
        return infoclass;
    }

    public void setInfoclass(Integer infoclass) {
        this.infoclass = infoclass;
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

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getFcount() {
        return fcount;
    }

    public void setFcount(Integer fcount) {
        this.fcount = fcount;
    }

    public Integer getRcount() {
        return rcount;
    }

    public void setRcount(Integer rcount) {
        this.rcount = rcount;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

}
