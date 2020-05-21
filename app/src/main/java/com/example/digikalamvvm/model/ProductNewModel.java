package com.example.digikalamvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductNewModel {

    @SerializedName("idstore")
    @Expose
    private String idstore;
    @SerializedName("idproduct")
    @Expose
    private String idproduct;
    @SerializedName("idcolor")
    @Expose
    private String idcolor;
    @SerializedName("garanti")
    @Expose
    private String garanti;
    @SerializedName("price_sale")
    @Expose
    private String priceSale;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("pic")
    @Expose
    private String pic;

    public String getIdstore() {
        return idstore;
    }

    public void setIdstore(String idstore) {
        this.idstore = idstore;
    }

    public String getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(String idproduct) {
        this.idproduct = idproduct;
    }

    public String getIdcolor() {
        return idcolor;
    }

    public void setIdcolor(String idcolor) {
        this.idcolor = idcolor;
    }

    public String getGaranti() {
        return garanti;
    }

    public void setGaranti(String garanti) {
        this.garanti = garanti;
    }

    public String getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(String priceSale) {
        this.priceSale = priceSale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic+"";
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}