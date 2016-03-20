package cn.edu.znufe.dhf.apisapp.model;

import java.util.List;

/**
 * Created by Aaric on 2016/3/16.
 */
public class TravelsMapObject {

    private Boolean ret;
    private Integer errcode;
    private String errmsg;
    private Integer ver;
    private TravelsBookObject data;

    public TravelsMapObject() {
    }

    public Boolean getRet() {
        return ret;
    }

    public void setRet(Boolean ret) {
        this.ret = ret;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public TravelsBookObject getData() {
        return data;
    }

    public void setData(TravelsBookObject data) {
        this.data = data;
    }

}
