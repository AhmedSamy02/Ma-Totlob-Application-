package com.example.dayfourtask;

import java.io.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import com.example.dayfourtask.fragments.*;
import com.example.dayfourtask.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.favourite);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.favourite:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, favouritesFragment.newInstance(getApplicationContext())).commit();
                return true;
            case R.id.cart:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, cartFragment.newInstance(getApplicationContext())).commit();
                return true;
            default:
                Toast.makeText(this, "Under Development", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

}