package com.example.sneakership;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;

public class CheckOutFragment extends Fragment {

    private ImageView image;
    private TextView name, price;
    private Button checkOut;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_check_out, container, false);
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
        name = view.findViewById(R.id.name);
        price = view.findViewById(R.id.price);
        checkOut = view.findViewById(R.id.checkOut);
        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Order Placed Successfully", Toast.LENGTH_SHORT).show();
                navController.navigate(R.id.action_checkOutFragment_to_sneakerFragment);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void setData() {
        if (getArguments() != null) {
            Glide.with(this).load(getArguments().getString("image")).into(image);
            name.setText(getArguments().getString("name"));
            price.setText("₹" + getArguments().getInt("price"));
        }
    }
}