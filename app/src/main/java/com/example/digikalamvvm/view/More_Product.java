package com.example.digikalamvvm.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.digikalamvvm.R;
import com.example.digikalamvvm.Util.Convert_px;
import com.example.digikalamvvm.Util.Slider_pager_adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager.widget.ViewPager;


public class More_Product extends AppCompatActivity {
    private static final String TAG = "More_Product";

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.);
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
        Tv_title_product_fa=findViewById(R.id.Tv_title_product_fa);
        Im_shop=findViewById(R.id.Im_shop);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Tv_toolbar_title=findViewById(R.id.Tv_toolbar_title);
        Scrollview=findViewById(R.id.Scrollview);
        Tv_title_product_en=findViewById(R.id.Tv_title_product_en);
        Tv_sec=findViewById(R.id.Tv_sec);
        Tv_min=findViewById(R.id.Tv_min);
        Tv_hour=findViewById(R.id.Tv_hour);
        linertimer=findViewById(R.id.linertimer);
        linerlayout_slider=findViewById(R.id.linerlayout_slider);
        viewpager=findViewById(R.id.viewpager);
        Im_back=findViewById(R.id.Im_back);
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
    void  Gettimer()
    {
        Api_timer.Getmethod_timer(getApplicationContext(),Tv_sec,Tv_min,Tv_hour);
    }
    void Getproduct()
    {
        Api_product.Getpost(More_Product.this, Integer.parseInt(getintent.getStringExtra("idproduct")), new Api_product.interface_poduct() {
            @Override
            public void list(List<Datamodel_product> datamodel_products) {
                for (int i = 0; i <datamodel_products.size() ; i++) {
                    Datamodel_product datamodel_product=datamodel_products.get(i);
                    titletoolbar=datamodel_product.getName();
                     Tv_title_product_fa.setText(datamodel_product.getName());
                    Tv_title_product_en.setText(datamodel_product.getNameen());
                }
            }
        }, new Api_product.interface_images() {
            @Override
            public void listimages(List<String> Images) {
                idview=new int[Images.size()];
                Sliderindactor(Images.size());
                slider_pageradapter=new Slider_pageradapter(More_Product.this,More_Product.this,Images,idview);
                viewpager.setAdapter(slider_pageradapter);
            }
        });
    }

    void Sliderindactor(final int len)
    {
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(Convert_px.convertpx(30,getApplicationContext()),Convert_px.convertpx(30,getApplicationContext()));
        layoutParams.setMargins(0,0,13,0);
        for (int i = 0; i <len ; i++) {
            int id=View.generateViewId();
            idview[i]=id;
            View view=new View(More_Product.this);
            view.setBackgroundResource(R.drawable.shape_slider_noactive);
            view.setLayoutParams(layoutParams);
            view.setId(id);
            linerlayout_slider.addView(view);
        }

    }

}
