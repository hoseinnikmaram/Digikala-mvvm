package com.example.digikalamvvm.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListCatModel {

    @SerializedName("idcat")
    @Expose
    private String idcat;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nameen")
    @Expose
    private String nameen;
    @SerializedName("subid")
    @Expose
    private String subid;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("subcat")
    @Expose
    private List<SubCatModel> subCatModel = null;

    public String getIdcat() {
        return idcat;
    }

    public void setIdcat(String idcat) {
        this.idcat = idcat;
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

    public String getSubid() {
        return subid;
    }

    public void setSubid(String subid) {
        this.subid = subid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<SubCatModel> getSubCatModel() {
        return subCatModel;
    }

    public void setSubCatModel(List<SubCatModel> subCatModel) {
        this.subCatModel = subCatModel;
    }

}
