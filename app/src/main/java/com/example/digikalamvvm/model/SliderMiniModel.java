package com.example.digikalamvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SliderMiniModel {

    @SerializedName("idslider")
    @Expose
    private String idslider;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("layer")
    @Expose
    private String layer;
    @SerializedName("val")
    @Expose
    private String val;
    @SerializedName("pic")
    @Expose
    private String pic;
    @SerializedName("iduser")
    @Expose
    private String iduser;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("type")
    @Expose
    private String type;

    public String getIdslider() {
        return idslider;
    }

    public void setIdslider(String idslider) {
        this.idslider = idslider;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
