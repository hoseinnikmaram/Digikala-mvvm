package com.example.digikalamvvm.Util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.digikalamvvm.R;

import androidx.databinding.BindingAdapter;

public class AdabterBinding {

    @BindingAdapter("image")
    public static void Image(ImageView view, String url){
        Glide.with(view).load(url.replace("localhost","192.168.43.160")).apply(new RequestOptions().placeholder(R.drawable.logo_sp).error(R.drawable.logo_sp)).into(view);


    }
}
