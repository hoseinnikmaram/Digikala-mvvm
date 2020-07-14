
package com.example.digikalamvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InfoModel {

    @SerializedName("idproduct")
    @Expose
    private String idproduct;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nameen")
    @Expose
    private String nameen;
    @SerializedName("idbrand")
    @Expose
    private String idbrand;
    @SerializedName("colors")
    @Expose
    private String colors;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("des")
    @Expose
    private String des;
    @SerializedName("kholase")
    @Expose
    private String kholase;
    @SerializedName("pic")
    @Expose
    private String pic;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("iduser")
    @Expose
    private String iduser;
    @SerializedName("idcat")
    @Expose
    private String idcat;
    @SerializedName("weight")
    @Expose
    private String weight;

    public String getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(String idproduct) {
        this.idproduct = idproduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameen() {
        return nameen;
    }

    public void setNameen(String nameen) {
        this.nameen = nameen;
    }

    public String getIdbrand() {
        return idbrand;
    }

    public void setIdbrand(String idbrand) {
        this.idbrand = idbrand;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getKholase() {
        return kholase;
    }

    public void setKholase(String kholase) {
        this.kholase = kholase;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getIdcat() {
        return idcat;
    }

    public void setIdcat(String idcat) {
        this.idcat = idcat;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

}
