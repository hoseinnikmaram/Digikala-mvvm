package com.example.digikalamvvm.Util;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import com.example.digikalamvvm.model.HomeModel;
import com.example.digikalamvvm.model.SliderModel;
import com.example.digikalamvvm.R;
import com.pnikosis.materialishprogress.ProgressWheel;

import androidx.viewpager.widget.ViewPager;
 import com.example.digikalamvvm.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class Slider_config {
    Context context;
    ProgressWheel progress_wheel;
    ViewPager viewPager;
    ActivityMainBinding binding;
    int idview[];
    int countslider;
    LinearLayout linerlayout_slider;
    Slider_pager_adapter slider_pageradapter;
    HomeModel homeModel;

    public Slider_config(ActivityMainBinding binding, Context context, ViewPager viewpager, LinearLayout linerlayout_slider, HomeModel homeModel) {

        this.context = context;
        this.viewPager = viewpager;
        this.binding = binding;
        this.linerlayout_slider = linerlayout_slider;
        this.homeModel = homeModel;
        Setup_slider();
    }

    void Setup_slider() {
        final List<String> stringsarray = new ArrayList<>();

        List<SliderModel> ListSlider = homeModel.getSliderModel();

        for (int i = 0; i < ListSlider.size(); i++) {
            SliderModel sliderModel = ListSlider.get(i);
            stringsarray.add(sliderModel.getPic());
        }
        idview = new int[ListSlider.size()];
        slider_pageradapter = new Slider_pager_adapter(binding, context, stringsarray, idview);
        viewPager.setAdapter(slider_pageradapter);
        Getslider_auto_Changeitems(ListSlider.size());
        Sliderindactor(ListSlider.size());


    }

    void Sliderindactor(final int len) {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Convert_px.convertpx(30, context), Convert_px.convertpx(30, context));
        layoutParams.setMargins(0, 0, 13, 0);
        for (int i = 0; i < len; i++) {
            int id = View.generateViewId();
            idview[i] = id;
            View view = new View(binding.contentMain.getRoot().getContext());
            view.setBackgroundResource(R.drawable.shape_slider_noactive);
            view.setLayoutParams(layoutParams);
            view.setId(id);
            linerlayout_slider.addView(view);
        }

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

/*                                for (int i = 0; i < idview.length; i++) {
                                    //  View view=activity.findViewById(idview[i]);

                                    View view = binding.contentMain.linerlayoutSlider.findViewById(idview[i]);

                                    if (i == countslider) {
                                        view.setBackgroundResource(R.drawable.shape_slider_active);
                                    } else {
                                        view.setBackgroundResource(R.drawable.shape_slider_noactive);
                                    }
                                }

 */
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
