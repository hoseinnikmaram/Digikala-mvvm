package com.example.digikalamvvm.Util.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.digikalamvvm.model.ListCatModel;
import com.example.digikalamvvm.R;
import com.example.digikalamvvm.databinding.ItemsCategoryHomeBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public  class Adapter_Recyclerview_category_home extends RecyclerView.Adapter<Adapter_Recyclerview_category_home.viewholder> {
    Context context;
    List<ListCatModel> datamodel_cagegory_homes;
    public Adapter_Recyclerview_category_home(Context context, List<ListCatModel> ListCatModel)
    {
        this.context=context;
        this.datamodel_cagegory_homes=ListCatModel;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    //    View view= LayoutInflater.from(context).inflate(R.layout.items_category_home,parent,false);
      //  return new videwholder(view);

        return new viewholder((ItemsCategoryHomeBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.items_category_home,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
       // holder.Btn_category.setText(datamodel_cagegory_home.getTitle());

           holder.binding.setData(datamodel_cagegory_homes.get(position).getName());
//       holder.itemView.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//
//           }
//       });
    }

    @Override
    public int getItemCount() {
        return datamodel_cagegory_homes.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
    //    Button Btn_category;
         ItemsCategoryHomeBinding binding;

    //    public videwholder(View view) {
          //  super(view);
          //  Btn_category=view.findViewById(R.id.Btn_category);
    public viewholder(@NonNull ItemsCategoryHomeBinding binding) {

        super(binding.getRoot());
            this.binding=binding;
        }
    }
}
