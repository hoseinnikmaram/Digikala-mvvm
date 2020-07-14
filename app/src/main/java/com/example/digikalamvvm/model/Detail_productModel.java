
package com.example.digikalamvvm.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Detail_productModel {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("info")
    @Expose
    private InfoModel infoModel;
    @SerializedName("images")
    @Expose
    private List<ImageModel> imageModels = null;
    @SerializedName("price_offer")
    @Expose
    private List<Object> priceOffer = null;
    @SerializedName("prices")
    @Expose
    private List<PriceModel> priceModels = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public InfoModel getInfoModel() {
        return infoModel;
    }

    public void setInfoModel(InfoModel infoModel) {
        this.infoModel = infoModel;
    }

    public List<ImageModel> getImageModels() {
        return imageModels;
    }

    public void setImageModels(List<ImageModel> imageModels) {
        this.imageModels = imageModels;
    }

    public List<Object> getPriceOffer() {
        return priceOffer;
    }

    public void setPriceOffer(List<Object> priceOffer) {
        this.priceOffer = priceOffer;
    }

    public List<PriceModel> getPriceModels() {
        return priceModels;
    }

    public void setPriceModels(List<PriceModel> priceModels) {
        this.priceModels = priceModels;
    }

}
