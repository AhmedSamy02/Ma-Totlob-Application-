package com.example.dayfourtask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.dayfourtask.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setProduct1(new Product(getResources().getDrawable(R.drawable.sprite), "Sprite Can", "325ml, Price", 1.49));
        binding.setProduct2(new Product(getResources().getDrawable(R.drawable.diet_coke), "Diet Coke", "355ml, Price", 1.99));
        binding.setProduct3(new Product(getResources().getDrawable(R.drawable.apple_and_grape), "Apple & Grape Juice", "2L, Price", 15.49));
        binding.setProduct4(new Product(getResources().getDrawable(R.drawable.coca_cola), "Coca Cola Can", "325ml, Price", 4.99));
        binding.setProduct5(new Product(getResources().getDrawable(R.drawable.pepsi), "Pepsi Can", "330ml, Price", 4.99));
        binding.bottomNavigationView.setSelectedItemId(R.id.favourite);
    }
}