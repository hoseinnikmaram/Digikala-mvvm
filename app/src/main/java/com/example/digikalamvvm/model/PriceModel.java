
package com.example.digikalamvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PriceModel {

    @SerializedName("idstore")
    @Expose
    private String idstore;
    @SerializedName("idcolor")
    @Expose
    private String idcolor;
    @SerializedName("garanti")
    @Expose
    private String garanti;
    @SerializedName("price_sale")
    @Expose
    private String priceSale;

    public String getIdstore() {
        return idstore;
    }

    public void setIdstore(String idstore) {
        this.idstore = idstore;
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

}
