package com.example.digikalamvvm.model;

import com.google.gson.annotations.SerializedName;

public class ProductOfferModel {

@SerializedName("idstore")

public String idstore;



    @SerializedName("idproduct")
public String idproduct;
@SerializedName("idcolor")
public String idcolor;
@SerializedName("garanti")
public String garanti;
@SerializedName("price_sale")
public String priceSale;
@SerializedName("price_offer")
public String priceOffer;
@SerializedName("name")
public String name;
@SerializedName("pic")
public String pic;

public String getIdstore() {
return idstore;
}


public String getIdproduct() {
return idproduct+"";
}


public String getIdcolor() {
return idcolor;
}


public String getGaranti() {
return garanti;
}


public String getPriceSale() {
return priceSale+" تومان ";
}


public String getPriceOffer() {
return priceOffer+"";
}


public String getName() {
return name+"";
}


public String getPic() {
return pic +"";
}


}