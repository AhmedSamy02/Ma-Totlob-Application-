package com.example.dayfourtask;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.dayfourtask.databinding.ActivityAddToBasketBinding;

public class AddToBasket extends AppCompatActivity {
    ActivityAddToBasketBinding binding;
    int counter = 0;
    boolean added=false;
    TextView txt;
    TextView txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_basket);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_to_basket);
        binding.removeFromFavourites.setVisibility(View.GONE);
        txt2 = binding.excessAmount;
        txt = binding.numberOfProducts;
        binding.numberOfProducts.setText("1");
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            binding.fruitName.setText(bundle.getString("productName"));
            binding.fruitDescription.setText(bundle.getString("weight"));
            binding.price.setText(bundle.getString("price"));
            binding.productNameTitle.setTitle(bundle.getString("productName"));
            binding.fruitPicture.setImageResource(bundle.getInt("productImage"));
        }

        if(binding.getNumberOfProducts()!="21")
        {        binding.excessAmount.setVisibility(View.GONE);}
    }

    public void Increase(View view) {
        counter = Integer.parseInt((String) txt.getText());
        if (counter == 20) {
            txt2.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Excess Amount", Toast.LENGTH_SHORT).show();
        }
        else {
            counter++;
            txt.setText(Integer.toString(counter));
        }
    }
    public void decrease(View view)
    {
        if(counter==20)
            txt2.setVisibility(View.GONE);
        if(counter!=0) {
            counter--;
            txt.setText(Integer.toString(counter));
        }
        else {
            Toast.makeText(this, "Value Can't be less than zero", Toast.LENGTH_LONG).show();
        }
    }
    public void addToFavourits(View view)
    {
        if(!added)
        {
            binding.removeFromFavourites.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Added to favourites", Toast.LENGTH_SHORT).show();
            added=true;
        }
        else {
            added=false;
            Toast.makeText(this, "Removed from favourites", Toast.LENGTH_SHORT).show();
            binding.removeFromFavourites.setVisibility(View.GONE);
        }
    }

    public void AddToBasket(View view) {
        Toast.makeText(this, "Added to basket successfully", Toast.LENGTH_SHORT).show();
    }
}