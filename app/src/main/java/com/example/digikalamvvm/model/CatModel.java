package com.example.digikalamvvm.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CatModel {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("list-cat")
    @Expose
    private List<ListCatModel> listCatModel = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ListCatModel> getListCatModel() {
        return listCatModel;
    }

    public void setListCatModel(List<ListCatModel> listCatModel) {
        this.listCatModel = listCatModel;
    }

}
