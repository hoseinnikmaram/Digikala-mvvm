package com.example.digikalamvvm.view.custom;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.digikalamvvm.R;
import com.example.digikalamvvm.Util.Adapter.Adapter_new_product;
import com.example.digikalamvvm.model.ProductNewModel;
import com.example.digikalamvvm.model.ProductOfferModel;
import com.example.digikalamvvm.Util.Adapter.Adapter_product;
import com.example.digikalamvvm.databinding.ProductLayoutBinding;
import com.example.digikalamvvm.model.ProductPourforshModel;

import java.util.List;

import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class Custom_product extends RelativeLayout {
    ProductLayoutBinding binding;
    TextView Tv_title,Tv_product_all;
    RecyclerView recyclerview_product;
    Adapter_new_product adapter_product_new;
    Adapter_product adapter_product;

    public Custom_product(Context context) {
        super(context);
        Getlistproduct();
    }

    public Custom_product(Context context, AttributeSet attrs) {
        super(context, attrs);
        Getlistproduct();
    }

    public Custom_product(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Getlistproduct();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Custom_product(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Getlistproduct();
    }

    public void Getlistproduct()
    {
      //  View view= LayoutInflater.from(getContext()).inflate(R.layout.product_layout,this,true);

        binding= DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.product_layout, this, true);

        recyclerview_product=binding.recyclerviewProduct;
        Tv_title=binding.TvTitle;
       Tv_product_all=binding.TvProductAll;
    }
    public void getlist(List<ProductPourforshModel> listproducts){
        recyclerview_product.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
        adapter_product=new Adapter_product(getContext(),listproducts);
        recyclerview_product.setAdapter(adapter_product);
    }


    public void getlist_product_new(List<ProductNewModel> listproducts){
        recyclerview_product.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
        adapter_product_new=new Adapter_new_product(getContext(),listproducts);
        recyclerview_product.setAdapter(adapter_product_new);
    }

    public void Settitle(String title)
    {
    binding.setData(title);
    }

}
