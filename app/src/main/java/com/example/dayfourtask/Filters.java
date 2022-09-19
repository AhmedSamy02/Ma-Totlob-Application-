package com.example.dayfourtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dayfourtask.databinding.ActivityFiltersBinding;
import com.example.dayfourtask.databinding.ActivityMainBinding;

public class Filters extends AppCompatActivity {
    ActivityFiltersBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_filters);
        binding.eggs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.eggs.isChecked()) {
                    binding.eggs.setTextColor(getResources().getColor(R.color.green2));
                    Toast.makeText(getApplicationContext(), "You chose Eggs as a category", Toast.LENGTH_SHORT).show();
                }
                else
                    binding.eggs.setTextColor(getResources().getColor(R.color.black));
            }
        });
        binding.chips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.eggs.isChecked()) {
                    binding.chips.setTextColor(getResources().getColor(R.color.green2));
                    Toast.makeText(getApplicationContext(), "You chose chips as a category", Toast.LENGTH_SHORT).show();
                }
                else
                    binding.chips.setTextColor(getResources().getColor(R.color.black));
            }
        });
        binding.pasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.pasta.isChecked()) {
                    binding.pasta.setTextColor(getResources().getColor(R.color.green2));
                    Toast.makeText(getApplicationContext(), "You chose pasta as a category", Toast.LENGTH_SHORT).show();
                }
                else
                    binding.pasta.setTextColor(getResources().getColor(R.color.black));
            }
        });
        binding.fastFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.fastFood.isChecked()) {
                    binding.fastFood.setTextColor(getResources().getColor(R.color.green2));
                    Toast.makeText(getApplicationContext(), "You chose Fast Food as a category", Toast.LENGTH_SHORT).show();
                }
                else
                    binding.fastFood.setTextColor(getResources().getColor(R.color.black));
            }
        });
        binding.IC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.IC.isChecked()) {
                    binding.IC.setTextColor(getResources().getColor(R.color.green2));
                    Toast.makeText(getApplicationContext(), "You chose Individually collection as a Brand", Toast.LENGTH_SHORT).show();
                }
                else
                    binding.IC.setTextColor(getResources().getColor(R.color.black));
            }
        });
        binding.ifad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.ifad.isChecked()) {
                    binding.ifad.setTextColor(getResources().getColor(R.color.green2));
                    Toast.makeText(getApplicationContext(), "You chose Ifad as a Brand", Toast.LENGTH_SHORT).show();
                }
                else
                    binding.ifad.setTextColor(getResources().getColor(R.color.black));
            }
        });
        binding.kazi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.kazi.isChecked()) {
                    binding.kazi.setTextColor(getResources().getColor(R.color.green2));
                    Toast.makeText(getApplicationContext(), "You chose Kazi Farmas as a Brand", Toast.LENGTH_SHORT).show();
                }
                else
                    binding.kazi.setTextColor(getResources().getColor(R.color.black));
            }
        });
        binding.cocacola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.cocacola.isChecked()) {
                    binding.cocacola.setTextColor(getResources().getColor(R.color.green2));
                    Toast.makeText(getApplicationContext(), "You chose Coca Cola as a Brand", Toast.LENGTH_SHORT).show();
                }
                else
                    binding.cocacola.setTextColor(getResources().getColor(R.color.black));
            }
        });
        binding.apply.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            Toast.makeText(this, "Successfully filtered", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
    }
}