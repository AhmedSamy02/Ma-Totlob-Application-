package com.example.dayfourtask.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dayfourtask.Product;
import com.example.dayfourtask.R;
import com.example.dayfourtask.databinding.FragmentFavouritesBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link favouritesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class favouritesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public favouritesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment favouritesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static favouritesFragment newInstance(String param1, String param2) {
        favouritesFragment fragment = new favouritesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    FragmentFavouritesBinding binding;

    public static Fragment newInstance(Context applicationContext) {
        return new favouritesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_favourites,container,false);
        binding.setProduct1(new Product(getResources().getDrawable(R.drawable.sprite), "Sprite Can", "325ml, Price", 1.49));
        binding.setProduct2(new Product(getResources().getDrawable(R.drawable.diet_coke), "Diet Coke", "355ml, Price", 1.99));
        binding.setProduct3(new Product(getResources().getDrawable(R.drawable.apple_and_grape), "Apple & Grape Juice", "2L, Price", 15.49));
        binding.setProduct4(new Product(getResources().getDrawable(R.drawable.coca_cola), "Coca Cola Can", "325ml, Price", 4.99));
        binding.setProduct5(new Product(getResources().getDrawable(R.drawable.pepsi), "Pepsi Can", "330ml, Price", 4.99));
        return binding.getRoot();
    }
}