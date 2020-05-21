package com.example.digikalamvvm.Util.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.digikalamvvm.R;
import com.example.digikalamvvm.databinding.ItemsOfferBinding;
import com.example.digikalamvvm.model.ProductOfferModel;
import com.example.digikalamvvm.view.More_Product;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter_product_offer  extends RecyclerView.Adapter<Adapter_product_offer.viewholder>{
        Context context;
        List<ProductOfferModel> datamodel_cagegory_homes;

public Adapter_product_offer(Context context,List<ProductOfferModel> datamodel_cagegory_homes){
        this.context=context;
        this.datamodel_cagegory_homes=datamodel_cagegory_homes;
        }

@NonNull
@Override
public viewholder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        //          View view= LayoutInflater.from(context).inflate(R.layout.items_offer,parent,false);
        // return new videwholder(view);
        return new viewholder((ItemsOfferBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.items_product,parent,false));

        }

@Override
public void onBindViewHolder(@NonNull viewholder holder,int position){
        ProductOfferModel datamodel_cagegory_home=datamodel_cagegory_homes.get(position);
        // Glide.with(context).load(datamodel_cagegory_home.getPic().replace("localhost","192.168.43.54")).into(holder.Image_post);
        // holder.Tv_price.setText(Desimal_format_Interger.GetformatInteger(datamodel_cagegory_home.getPriceSale())+" تومان ");
        // holder.Tv_title.setText(datamodel_cagegory_home.getName());
        holder.binding.setData(datamodel_cagegory_home);

        holder.itemView.setOnClickListener(new View.OnClickListener(){
@Override
public void onClick(View v){
        Intent intent=new Intent(context, More_Product.class);
        intent.putExtra("idproduct",datamodel_cagegory_home.getIdproduct());
        intent.putExtra("offer","0");
        context.startActivity(intent);
        }
        });
        }

@Override
public int getItemCount(){
        return datamodel_cagegory_homes.size();
        }

public class viewholder extends RecyclerView.ViewHolder {


    ItemsOfferBinding binding;


    public viewholder(@NonNull ItemsOfferBinding binding) {

        super(binding.getRoot());
        this.binding = binding;
    }


}
}