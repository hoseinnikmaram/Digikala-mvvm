package com.example.digikalamvvm.Util;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import com.example.digikalamvvm.model.HomeModel;
import com.example.digikalamvvm.model.SliderModel;
import com.example.digikalamvvm.R;
import com.pnikosis.materialishprogress.ProgressWheel;

import androidx.viewpager.widget.ViewPager;
import me.relex.circleindicator.CircleIndicator;

import com.example.digikalamvvm.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class Slider_config {
    Context context;
    ProgressWheel progress_wheel;
    ViewPager viewPager;
    Activity activity;
    int idview[];
    int countslider;
    LinearLayout linerlayout_slider;
    Slider_pager_adapter slider_pageradapter;
    HomeModel homeModel;

    public  Slider_config(Activity activity, Context context, ViewPager viewpager, HomeModel Model) {

        this.context = context;
        this.viewPager = viewpager;
        this.activity = activity;
        this.homeModel = Model;
        Setup_slider();
    }

    void Setup_slider() {
        final List<String> stringsarray = new ArrayList<>();

        List<SliderModel> ListSlider = homeModel.getSliderModel();

        for (int i = 0; i < ListSlider.size(); i++) {
            SliderModel sliderModel = ListSlider.get(i);
            stringsarray.add(sliderModel.getPic());
        }
        slider_pageradapter = new Slider_pager_adapter( context, stringsarray);
        viewPager.setAdapter(slider_pageradapter);
        CircleIndicator indicator = (CircleIndicator) activity.findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
        Getslider_auto_Changeitems(ListSlider.size());


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
                                viewPager.setCurrentItem(countslider);
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
