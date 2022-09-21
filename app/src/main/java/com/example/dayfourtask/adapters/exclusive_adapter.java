package com.example.dayfourtask.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dayfourtask.AddToBasket;
import com.example.dayfourtask.R;
import com.example.dayfourtask.databinding.ActivityItemBinding;
import com.example.dayfourtask.models.item_product;

import java.util.ArrayList;

public class exclusive_adapter extends RecyclerView.Adapter<exclusive_adapter.ViewHolder> {
    private final Context mContext;
    private final ArrayList<item_product> mList;
    ActivityItemBinding binding;

    public exclusive_adapter(Context context, ArrayList<item_product> list) {
        this.mContext = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public exclusive_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.activity_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull exclusive_adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        item_product product = mList.get(position);
        if (product != null) {
            if (product.getImage() != null) {
                binding.fruitImage.setImageDrawable(product.getImage());
            }
            binding.fruitName.setText(product.getTitle());
            binding.price.setText("£E " +Integer.toString(product.getPrice()));
            binding.weight.setText(Integer.toString(product.getWeight())+" gm");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(holder.itemView.getContext(), AddToBasket.class);
                    intent.putExtra("productName",mList.get(position).getTitle());
                    intent.putExtra("price","£E"+Integer.toString(mList.get(position).getPrice()));
                    intent.putExtra("weight",Integer.toString(mList.get(position).getWeight())+" grams");
                    intent.putExtra("productImage",mList.get(position).getImageId());
                    holder.itemView.getContext().startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ActivityItemBinding itemRowBinding;

        public ViewHolder(ActivityItemBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }
    }
}
