package com.example.digikalamvvm.view.custom;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.digikalamvvm.R;
import com.example.digikalamvvm.Util.Adapter.Adapter_product;
import com.example.digikalamvvm.Util.Adapter.Adapter_product_offer;
import com.example.digikalamvvm.databinding.LayoutOfferBinding;
import com.example.digikalamvvm.databinding.ProductLayoutBinding;
import com.example.digikalamvvm.model.ProductOfferModel;

import java.util.List;

import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class Custom_product_offer extends RelativeLayout {
    LayoutOfferBinding binding;
    TextView Tv_title,Tv_product_all;
    RecyclerView recyclerview_product;
    Adapter_product_offer adapter_product;

    public Custom_product_offer(Context context) {
        super(context);
        Getlistproduct();
    }

    public Custom_product_offer(Context context, AttributeSet attrs) {
        super(context, attrs);
        Getlistproduct();
    }

    public Custom_product_offer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Getlistproduct();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Custom_product_offer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Getlistproduct();
    }

    public void Getlistproduct()
    {
        //   View view= LayoutInflater.from(getContext()).inflate(R.layout.layout_offer,this,true);
        //        recyclerview_product=view.findViewById(R.id.recyclerview_product);

        binding= DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.layout_offer, this, true);

        recyclerview_product=binding.recyclerviewProduct;

    }
    public void getlist(List<ProductOfferModel> listproducts){


        recyclerview_product.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
        adapter_product= new Adapter_product_offer(getContext(),listproducts);
        recyclerview_product.setAdapter(adapter_product);
    }



}

