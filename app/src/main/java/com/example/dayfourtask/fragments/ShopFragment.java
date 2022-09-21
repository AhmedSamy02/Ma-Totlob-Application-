package com.example.dayfourtask.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.dayfourtask.R;
import com.example.dayfourtask.databinding.FragmentShopBinding;
import com.example.dayfourtask.models.item_product;

public class ShopFragment extends Fragment {
    private ArrayAdapter<item_product> list;
    private FragmentShopBinding binding;
    public static Fragment newInstance(Context applicationContext) {
        return new ShopFragment();
    }

    public static ShopFragment newInstance(String param1, String param2) {
        ShopFragment fragment = new ShopFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shop, container, false);
        getFragmentManager().beginTransaction().replace(binding.list.getId(),exclusive_list_fragment.newInstance()).commit();
        return binding.getRoot();
    }
}