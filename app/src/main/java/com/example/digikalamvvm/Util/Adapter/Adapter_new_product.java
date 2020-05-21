package com.example.digikalamvvm.Util.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.digikalamvvm.R;
import com.example.digikalamvvm.databinding.ItemsProductBinding;
import com.example.digikalamvvm.databinding.ProductNewItemBinding;
import com.example.digikalamvvm.model.ProductNewModel;
import com.example.digikalamvvm.view.More_Product;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter_new_product extends RecyclerView.Adapter<Adapter_new_product.viewholder> {
    Context context;
    List<ProductNewModel> datamodel_cagegory_homes;

    public Adapter_new_product(Context context, List<ProductNewModel> datamodel_cagegory_homes) {
        this.context = context;
        this.datamodel_cagegory_homes = datamodel_cagegory_homes;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //  View view= LayoutInflater.from(context).inflate(R.layout.items_product,parent,false);
        // return new videwholder(view);
        return new viewholder((ProductNewItemBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.product_new_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        ProductNewModel datamodel_cagegory_home=datamodel_cagegory_homes.get(position);
        // Glide.with(context).load(datamodel_cagegory_home.getPic().replace("localhost","192.168.43.54")).into(holder.Image_post);
        // holder.Tv_price.setText(Desimal_format_Interger.GetformatInteger(datamodel_cagegory_home.getPriceSale())+" تومان ");
        // holder.Tv_title.setText(datamodel_cagegory_home.getName());
                 holder.binding.setData(datamodel_cagegory_home);

        Log.e("bb",datamodel_cagegory_home.getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, More_Product.class);
                intent.putExtra("idproduct", datamodel_cagegory_home.getIdproduct());
                intent.putExtra("offer", "0");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datamodel_cagegory_homes.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {


        ProductNewItemBinding binding;


        public viewholder(@NonNull ProductNewItemBinding binding) {

            super(binding.getRoot());
            this.binding = binding;
        }


    }
}
