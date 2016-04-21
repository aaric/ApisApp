package cn.edu.znufe.dhf.apisapp.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by aaric on 16/4/21.
 */
@DatabaseTable(tableName = "favourite_data")
public class FavouriteData {

    @DatabaseField(columnName = "_id", generatedId = true)
    private Integer id;
    @DatabaseField(canBeNull = false)
    private String title;
    @DatabaseField(canBeNull = false)
    private String url;
    @DatabaseField
    private String imageUrl;
    @DatabaseField
    private String description;
    @DatabaseField
    private String date;
    @DatabaseField(canBeNull = false, index = true)
    private String tagName;
    @DatabaseField(canBeNull = false)
    private Date insertTime;

    public FavouriteData() {
    }

    public FavouriteData(String title, String url, String tagName) {
        this.title = title;
        this.url = url;
        this.tagName = tagName;
        this.insertTime = Calendar.getInstance().getTime();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

}
