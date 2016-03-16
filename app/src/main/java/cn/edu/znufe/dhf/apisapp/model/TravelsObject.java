package cn.edu.znufe.dhf.apisapp.model;

/**
 * Created by Aaric on 2016/3/16.
 */
public class TravelsObject {

    private String title;
    private String text;
    private String bookUrl;
    private String headImage;
    private String userHeadImg;
    private String userName;
    private Boolean elite;
    private Integer routeDays;
    private Integer bookImgNum;
    private Integer viewCount;
    private Integer likeCount;
    private Integer commentCount;
    private String startTime;

    public TravelsObject() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getUserHeadImg() {
        return userHeadImg;
    }

    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getElite() {
        return elite;
    }

    public void setElite(Boolean elite) {
        this.elite = elite;
    }

    public Integer getRouteDays() {
        return routeDays;
    }

    public void setRouteDays(Integer routeDays) {
        this.routeDays = routeDays;
    }

    public Integer getBookImgNum() {
        return bookImgNum;
    }

    public void setBookImgNum(Integer bookImgNum) {
        this.bookImgNum = bookImgNum;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

}
