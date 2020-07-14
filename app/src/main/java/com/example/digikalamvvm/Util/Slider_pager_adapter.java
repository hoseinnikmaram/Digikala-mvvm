package com.example.digikalamvvm.Util;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.digikalamvvm.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.databinding.DataBindingUtil;

import com.example.digikalamvvm.databinding.ActivityMoreProductBinding;
import com.example.digikalamvvm.databinding.SliderLatyoutBinding;
import com.example.digikalamvvm.databinding.ActivityMainBinding;
public class Slider_pager_adapter extends PagerAdapter {

    Context context;
    List<String> strings;
    ImageView Image_slider;
    int[] idview;
    SliderLatyoutBinding sliderLatyoutBinding;

    private static final String TAG = "Slider_pageradapter";


    public Slider_pager_adapter(Context context, List<String> strings){
        this.context=context;
        this.strings=strings;


    }
    @Override
    public int getCount() {
        return strings.size();
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==object);
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
    //    View view= LayoutInflater.from(context).inflate(R.layout.slider_latyout,null);
        sliderLatyoutBinding=DataBindingUtil.inflate(LayoutInflater.from(container.getContext()),R.layout.slider_latyout,container,false);

    //    Image_slider=view.findViewById(R.id.Image_slider);
  //    Glide.with(context).load(strings.get(position).replace("localhost","192.168.43.54")).apply(new RequestOptions().placeholder(R.drawable.logo_sp).error(R.drawable.logo_sp)).into(Image_slider);
        sliderLatyoutBinding.setData(strings.get(position));

    //    container.addView(view);
      //  return view;

        container.addView(sliderLatyoutBinding.getRoot());
        return sliderLatyoutBinding.getRoot();
    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
     //   ((ViewPager) container).removeView((View) object);

        container.removeView((View) object);

    }


}
