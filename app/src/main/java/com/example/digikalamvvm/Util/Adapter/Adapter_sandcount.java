package com.example.digikalamvvm.Util.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.digikalamvvm.model.SliderModel;
import com.example.digikalamvvm.R;
import com.example.digikalamvvm.databinding.TypeSpanBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


public class Adapter_sandcount extends RecyclerView.Adapter<Adapter_sandcount.videwholder> {
    Context context;

    List<SliderModel> sliderModels;
    public Adapter_sandcount(Context context, List<SliderModel> sliderModels)
    {
       this.context=context;
       this.sliderModels = sliderModels;
    }

    @NonNull
    @Override
    public videwholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new videwholder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.type_span, parent, false));


    }

    @Override
    public void onBindViewHolder(@NonNull videwholder holder, int position) {
        final SliderModel sliderModel= sliderModels.get(position);
       // Glide.with(context).load(datamodel_cagegory_home.getPic().replace("localhost","192.168.43.54")).into(holder.Image_span_count);
        holder.Image_span_count.setData(sliderModel.getPic());
    }



    @Override
    public int getItemCount() {
        return sliderModels.size();
    }

    public class videwholder extends RecyclerView.ViewHolder {
      //  ImageView Image_span_count;
        TypeSpanBinding Image_span_count;
        public videwholder(TypeSpanBinding Image_span_count) {
            super(Image_span_count.getRoot());
            this.Image_span_count=Image_span_count;
        }
    }
}
