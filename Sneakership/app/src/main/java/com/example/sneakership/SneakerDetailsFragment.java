package com.example.sneakership;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;

public class SneakerDetailsFragment extends Fragment {

    private ImageView image;
    private TextView brand, name, year, price;
    private Button addToCart;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sneaker_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        initViews(view);
        setData();
    }

    private void initViews(View view) {
        image = view.findViewById(R.id.image);
        brand = view.findViewById(R.id.brand);
        name = view.findViewById(R.id.name);
        year = view.findViewById(R.id.year);
        price = view.findViewById(R.id.price);
        addToCart = view.findViewById(R.id.addToCart);
    }

    @SuppressLint("SetTextI18n")
    private void setData() {
        if (getArguments() != null) {
            String itemName = getArguments().getString("name");
            int itemPrice = getArguments().getInt("price");
            String itemImage = getArguments().getString("image");
            int itemYear = getArguments().getInt("year");
            String itemBrand = getArguments().getString("brand");

            Glide.with(this).load(itemImage).into(image);
            brand.setText(itemBrand);
            name.setText(itemName);
            year.setText(itemYear + " ");
            price.setText("₹" + itemPrice);

            Bundle bundle = new Bundle();
            bundle.putString("image", itemImage);
            bundle.putString("name", itemName);
            bundle.putInt("price", itemPrice);

            addToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    navController.navigate(R.id.action_sneakerDetailsFragment_to_checkOutFragment, bundle);
                }
            });
        }
    }
}