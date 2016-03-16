package cn.edu.znufe.dhf.apisapp.model;

import java.util.List;

/**
 * Created by Aaric on 2016/3/16.
 */
public class HealthyMapObject {

    private Boolean status;
    private Integer total;
    private List<HealthyObject> tngou;

    public HealthyMapObject() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<HealthyObject> getTngou() {
        return tngou;
    }

    public void setTngou(List<HealthyObject> tngou) {
        this.tngou = tngou;
    }
    
}
