package com.example.digikalamvvm.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeModel {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("slider")
    @Expose
    private List<SliderModel> sliderModel = null;
    @SerializedName("slider-mini")
    @Expose
    private List<SliderMiniModel> sliderMini = null;
    @SerializedName("product-offer")
    @Expose
    private List<ProductOfferModel> productOffer = null;
    @SerializedName("product-pourforsh")
    @Expose
    private List<ProductPourforshModel> productPourforshModels = null;
    @SerializedName("product-new")
    @Expose
    private List<ProductNewModel> productNewModel = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public List<SliderModel> getSliderModel() {
        return sliderModel;
    }

    public void setSliderModel(List<SliderModel> sliderModel) {
        this.sliderModel = sliderModel;
    }

    public List<SliderMiniModel> getSliderMini() {
        return sliderMini;
    }

    public void setSliderMini(List<SliderMiniModel> sliderMini) {
        this.sliderMini = sliderMini;
    }

    public List<ProductOfferModel> getProductOffer() {
        return productOffer;
    }

    public void setProductOffer(List<ProductOfferModel> productOffer) {
        this.productOffer = productOffer;
    }

    public List<ProductPourforshModel> getProductPourforshModels() {
        return productPourforshModels;
    }

    public void setProductPourforshModels(List<ProductPourforshModel> productPourforshModels) {
        this.productPourforshModels = productPourforshModels;
    }

    public List<ProductNewModel> getProductNewModel() {
        return productNewModel;
    }

    public void setProductNewModel(List<ProductNewModel> productNewModel) {
        this.productNewModel = productNewModel;
    }

}
