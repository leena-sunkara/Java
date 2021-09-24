package com.example.sneakership;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class SneakerAdapter extends RecyclerView.Adapter<SneakerAdapter.SneakerVH> {

    private List<ResponseModel> responseList;
    private ItemClickListener itemClickListener;

    public SneakerAdapter(List<ResponseModel> responseList, ItemClickListener itemClickListener) {
        this.responseList = responseList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public SneakerVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new SneakerVH(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SneakerVH holder, int position) {
        holder.setData(responseList.get(position));
    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateData(List<ResponseModel> responseList) {
        this.responseList = responseList;
        notifyDataSetChanged();
    }

    public static class SneakerVH extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView name, price;
        private LinearLayout linearLayout;
        private ItemClickListener itemClickListener;

        public SneakerVH(@NonNull View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            initViews(itemView);
            this.itemClickListener = itemClickListener;
        }

        private void initViews(View itemView) {
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }

        @SuppressLint("SetTextI18n")
        private void setData(ResponseModel response) {
            String itemName = response.getName();
            int itemPrice = response.getRetailPrice();
            String itemImage = response.getMedia().getImageUrl();
            int itemYear = response.getYear();
            String itemBrand = response.getBrand();

            Glide.with(itemView).load(itemImage).into(image);
            name.setText(itemName);
            price.setText("₹" + itemPrice);

            Bundle bundle = new Bundle();
            bundle.putString("image", itemImage);
            bundle.putString("name", itemName);
            bundle.putInt("price", itemPrice);
            bundle.putString("brand", itemBrand);
            bundle.putInt("year", itemYear);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.onItemClick(getAdapterPosition(), bundle);
                }
            });
        }
    }
}
