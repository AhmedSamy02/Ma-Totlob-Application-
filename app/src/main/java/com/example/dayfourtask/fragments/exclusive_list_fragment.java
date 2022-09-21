package com.example.dayfourtask.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dayfourtask.R;
import com.example.dayfourtask.adapters.exclusive_adapter;
import com.example.dayfourtask.databinding.FragmentExclusiveListFragmentBinding;
import com.example.dayfourtask.models.item_product;

import java.util.ArrayList;
import java.util.List;

public class exclusive_list_fragment extends Fragment {
    FragmentExclusiveListFragmentBinding binding;
    ArrayList<item_product> list;
    private exclusive_adapter mAdapter;


    public static exclusive_list_fragment newInstance() {
        return new exclusive_list_fragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_exclusive_list_fragment, container, false);
        List<item_product>the_list = null;
        list=new ArrayList<item_product>();
        list.add(new item_product(R.drawable.banana,getResources().getDrawable(R.drawable.banana),"Organic Banana",1000, 5));
        list.add(new item_product(R.drawable.apple,getResources().getDrawable(R.drawable.apple),"Red Apples",1000,  20));
        list.add(new item_product(R.drawable.grapes,getResources().getDrawable(R.drawable.grapes),"Grapes",750,  7));
        list.add(new item_product(R.drawable.peach,getResources().getDrawable(R.drawable.peach),"Peach",800,  8));
        list.add(new item_product(R.drawable.mango,getResources().getDrawable(R.drawable.mango),"Mango",1000,  11));
        list.add(new item_product(R.drawable.eggs,getResources().getDrawable(R.drawable.eggs),"Eggs",25,  2));
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        populateRecyclerView(list);
    }
    private void populateRecyclerView(ArrayList<item_product> offersArrayList) {
        mAdapter= new exclusive_adapter(getActivity(),offersArrayList);
        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        binding.recycler.setLayoutManager(mLayoutManager);
        binding.recycler.setItemAnimator(new DefaultItemAnimator());
        binding.recycler.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}