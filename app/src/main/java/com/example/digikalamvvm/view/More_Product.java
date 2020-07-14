package com.example.digikalamvvm.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.digikalamvvm.R;
import com.example.digikalamvvm.Util.Adapter.Adapter_Recyclerview_category_home;
import com.example.digikalamvvm.Util.Convert_px;
import com.example.digikalamvvm.Util.SetupTimer;
import com.example.digikalamvvm.Util.Slider_pager_adapter;
import com.example.digikalamvvm.ViewModel.Viewmodel_Detail_Product;
import com.example.digikalamvvm.ViewModel.Viewmodel_Timer;
import com.example.digikalamvvm.databinding.ActivityMoreProductBinding;
import com.example.digikalamvvm.model.CatModel;
import com.example.digikalamvvm.model.Detail_productModel;
import com.example.digikalamvvm.model.ImageModel;
import com.example.digikalamvvm.model.TimerModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;
import me.relex.circleindicator.CircleIndicator;
import me.relex.circleindicator.CircleIndicator3;


public class More_Product extends AppCompatActivity {


    private static final String TAG = "More_Product";
    ActivityMoreProductBinding binding;

    TextView Tv_title_product_fa,Tv_title_product_en,Tv_sec,Tv_min,Tv_hour,Tv_toolbar_title;
    LinearLayout linertimer,linerlayout_slider;
    Intent getintent;

    ImageView Im_back,Im_shop;
    ViewPager viewpager;
    Slider_pager_adapter slider_pageradapter;
    int idview[];
    ScrollView Scrollview;
    String titletoolbar;
    int checkscroll=0;
    Toolbar toolbar;

    CircleIndicator indicator;
    private int countslider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_more__product);
        getintent=getIntent();
        Cast();
        checktimer();
        Getproduct();
        Scrollview.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int scrolltoolbarchange=Scrollview.getScrollY();
                int dpsize= Convert_px.convertpx(scrolltoolbarchange,getApplicationContext());
                int colorblack= Color.argb(scrolltoolbarchange,250,66,66);
                int colorwhite=Color.argb(255,250,66,66);

                if(scrolltoolbarchange > 220){
                    toolbar.setBackgroundColor(colorwhite);
                    Im_back.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.ic_arrow_back_white_24dp,null));
                    Im_shop.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.ic_shop_white,null));
                }
                else
                {
                    Im_back.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.icon_product_black_toolbar,null));
                    Im_shop.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.ic_shop_black_toolbar,null));

                    toolbar.setBackgroundColor(colorblack);
                    Tv_toolbar_title.setText("");
                }

                if(dpsize > 307){
                    if(checkscroll==0) {
                        Animation animation = AnimationUtils.loadAnimation((More_Product.this), R.anim.anim_toolbar_title);
                        Tv_toolbar_title.startAnimation(animation);
                        checkscroll=1;
                    }
                    Tv_toolbar_title.setText(titletoolbar);
                }
                else
                {
                    checkscroll=0;
                    Tv_toolbar_title.setText("");
                }

            }
        });
    }
    void Cast(){
        Tv_title_product_fa=binding.TvTitleProductFa;
        Im_shop=binding.ImShop;
        toolbar=binding.toolbar;
        setSupportActionBar(toolbar);
        Tv_toolbar_title=binding.TvToolbarTitle;
        Scrollview=binding.Scrollview;
        Tv_title_product_en=binding.TvTitleProductEn;
        Tv_sec=binding.TvSec;
        Tv_min=binding.TvMin;
        Tv_hour=binding.TvHour;
        linertimer=binding.linertimer;
        indicator=binding.indicator;
        viewpager=binding.viewpager;
        Im_back=binding.ImBack;
        Im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    void checktimer(){
        String check=getintent.getStringExtra("offer");
        if(check!=null && check.equals("0")){
            linertimer.setVisibility(View.GONE);
        }else
        {
            linertimer.setVisibility(View.VISIBLE);
            Gettimer();
        }
    }

        private void Gettimer() {
        Viewmodel_Timer viewmodel_timer = ViewModelProviders.of(this).get(Viewmodel_Timer.class);
        final MutableLiveData<TimerModel> mutableLiveData_timer = viewmodel_timer.Timer_Mutable();
        MutableLiveData<Boolean> mutableLiveData_status = viewmodel_timer.liveData_status;
        Log.e("eroree","0");

        mutableLiveData_status.observe(this,s->{
            if(!s){
                Toast.makeText(More_Product.this, "سرور در دسترس نیست", Toast.LENGTH_SHORT).show();
                Log.e("eroree","1");

            }


            else {
                mutableLiveData_timer.observe(this, new Observer<TimerModel>() {
                    @Override
                    public void onChanged(TimerModel timerModel) {
                        Log.e("eroree","2");


                        SetupTimer.Getmethod_timer(More_Product.this,Tv_sec,Tv_min,Tv_hour,timerModel.getTimer());




                    }
                });

            }

        });


    }
    void Getproduct()
    {


        Viewmodel_Detail_Product viewmodel_detail_product = new ViewModelProvider(this).get(Viewmodel_Detail_Product.class);
        final MutableLiveData<Detail_productModel> mutableLiveData_DetailProduct = viewmodel_detail_product.Detail_Product_Mutable(getintent.getStringExtra("idproduct"));
        MutableLiveData<Boolean> mutableLiveData_status = viewmodel_detail_product.liveData_status;

        mutableLiveData_status.observe(this,s->{
            if(!s){
                Toast.makeText(this, "سرور در دسترس نیست", Toast.LENGTH_SHORT).show();
            }


            else {
                mutableLiveData_DetailProduct.observe(this, new Observer<Detail_productModel>() {
                    @Override
                    public void onChanged(Detail_productModel detail_productModel) {

                        Log.e("ch",detail_productModel.getStatus());
                        titletoolbar=detail_productModel.getInfoModel().getName()+"";
                        binding.setData(detail_productModel);

                        List<ImageModel> imageModels=detail_productModel.getImageModels();
                        List<String> Images=new ArrayList<>();
                        for (int i=0;i<imageModels.size();i++){
                            Images.add(imageModels.get(i).getUrl());

                        }

                        slider_pageradapter=new Slider_pager_adapter(More_Product.this,Images);
                        viewpager.setAdapter(slider_pageradapter);
                        indicator.setViewPager(viewpager);
                        Getslider_auto_Changeitems(Images.size());

                    }
                });

            }

        });



    }

    void Getslider_auto_Changeitems(final int len) {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                countslider = 0;
                while (true) {
                    try {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                viewpager.setCurrentItem(countslider);

                                countslider++;
                            }
                        });
                        Thread.sleep(5000);
                        if (countslider == len) {
                            countslider = 0;
                        }
                    } catch (Exception e) {

                    }
                }
            }
        }).start();


    }

    }




