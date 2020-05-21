package com.example.digikalamvvm.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebService {

    String baseurl="http://192.168.1.3/digikala/api/";
    Api api;
    public WebService(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api= retrofit.create(Api.class);
    }

    public Api getApi() {
        return api;
    }
}
