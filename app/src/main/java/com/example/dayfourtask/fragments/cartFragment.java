package com.example.dayfourtask.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.dayfourtask.MainActivity;
import com.example.dayfourtask.Product;
import com.example.dayfourtask.R;
import com.example.dayfourtask.databinding.FragmentCartBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link cartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class cartFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public cartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment cartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static cartFragment newInstance(String param1, String param2) {
        cartFragment fragment = new cartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    FragmentCartBinding binding;

    public static Fragment newInstance(Context applicationContext) {
        return new cartFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    Product[] product = new Product[4];
    double sum = 0;
    boolean pressed = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false);
        product[0] = new Product(getResources().getDrawable(R.drawable.pepperred), "Bell Pepper Red", "1kg, Price", 4.99);
        product[1] = new Product(getResources().getDrawable(R.drawable.eggs), "Egg Chicken Red", "4pcs, Price", 1.99);
        product[2] = new Product(getResources().getDrawable(R.drawable.banana), "Organic Bananas", "12kg, Price", 2.99);
        product[3] = new Product(getResources().getDrawable(R.drawable.ginger), "Ginger", "250gm, Price", 2.99);
        binding.setProduct1(product[0]);
        binding.setProduct2(product[1]);
        binding.setProduct3(product[2]);
        binding.setProduct4(product[3]);
        sum += product[0].price + product[1].price + product[2].price + product[3].price;
        binding.setTotalPrice("$" + Double.toString(sum));
        binding.increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (product[0].numberOfProducts == 15)
                    Toast.makeText(getActivity(), "Excess Amount", Toast.LENGTH_SHORT).show();
                else {
                    product[0].numberOfProducts++;
                    sum += product[0].price;
                    binding.setTotalPrice("$" + Double.toString(sum));
                }
                binding.numberOfProducts.setText(product[0].getNumberOfProducts());
            }
        });
        binding.checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Checkout Approval");
                builder.setCancelable(true);
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ViewDialog viewDialog=new ViewDialog();
                        viewDialog.showDialog(getActivity());
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                if (product[0].numberOfProducts == 0 && product[1].numberOfProducts == 0 && product[2].numberOfProducts == 0 && product[3].numberOfProducts == 0) {
                    Toast.makeText(getActivity(), "Are you Kidding ME !! \nThere's no items", Toast.LENGTH_SHORT).show();
                    return;
                }
                String s[] = new String[4];
                for (int i = 0; i < 4; i++) {
                    s[i] = new String();
                    s[i] = product[i].productName + " --> " + product[i].numberOfProducts + " * " + product[i].price + '\n';
                }
                builder.setMessage("Are you sure you buy :-\n" + s[0] + s[1] + s[2] + s[3]);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        binding.increase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (product[1].numberOfProducts == 15)
                    Toast.makeText(getActivity(), "Excess Amount", Toast.LENGTH_SHORT).show();
                else {
                    product[1].numberOfProducts++;
                    sum += product[1].price;
                    binding.setTotalPrice("$" + Double.toString(sum));
                }
                binding.numberOfProducts2.setText(product[1].getNumberOfProducts());
            }
        });
        binding.increase3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Increase3(binding.getRoot());
            }
        });
        binding.increase4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Increase4(binding.getRoot());
            }
        });
        binding.decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrease(binding.getRoot());
            }
        });
        binding.decrease2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrease2(binding.getRoot());
            }
        });
        binding.decrease3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrease3(binding.getRoot());
            }
        });
        binding.decrease4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrease4(binding.getRoot());
            }
        });
        return binding.getRoot();
    }

    public void Increase3(View view) {
        if (product[2].numberOfProducts == 15)
            Toast.makeText(getActivity(), "Excess Amount", Toast.LENGTH_SHORT).show();
        else {
            product[2].numberOfProducts++;
            sum += product[2].price;
            binding.setTotalPrice("$" + Double.toString(sum));
        }
        binding.numberOfProducts3.setText(product[2].getNumberOfProducts());
    }

    public void Increase4(View view) {
        if (product[3].numberOfProducts == 15)
            Toast.makeText(getActivity(), "Excess Amount", Toast.LENGTH_SHORT).show();
        else {
            product[3].numberOfProducts++;
            sum += product[3].price;
            binding.setTotalPrice("$" + Double.toString(sum));
        }
        binding.numberOfProducts4.setText(product[3].getNumberOfProducts());
    }

    public void decrease(View view) {
        if (product[0].numberOfProducts == 0)
            Toast.makeText(getActivity(), "The value can't be less than zero", Toast.LENGTH_SHORT).show();
        else {
            product[0].numberOfProducts--;
            sum -= product[0].price;
            binding.setTotalPrice("$" + Double.toString(sum));
        }
        binding.numberOfProducts.setText(product[0].getNumberOfProducts());
    }

    public void decrease2(View view) {
        if (product[1].numberOfProducts == 0)
            Toast.makeText(getActivity(), "The value can't be less than zero", Toast.LENGTH_SHORT).show();
        else {
            product[1].numberOfProducts--;
            sum -= product[1].price;
            binding.setTotalPrice("$" + Double.toString(sum));
        }
        binding.numberOfProducts2.setText(product[1].getNumberOfProducts());
    }

    public void decrease3(View view) {
        if (product[2].numberOfProducts == 0)
            Toast.makeText(getActivity(), "The value can't be less than zero", Toast.LENGTH_SHORT).show();
        else {
            product[2].numberOfProducts--;
            sum -= product[2].price;
            binding.setTotalPrice("$" + Double.toString(sum));
        }
        binding.numberOfProducts3.setText(product[2].getNumberOfProducts());
    }

    public void decrease4(View view) {
        if (product[3].numberOfProducts == 0)
            Toast.makeText(getActivity(), "The value can't be less than zero", Toast.LENGTH_SHORT).show();
        else {
            product[3].numberOfProducts--;
            sum -= product[3].price;
            binding.setTotalPrice("$" + Double.toString(sum));
        }
        binding.numberOfProducts4.setText(product[3].getNumberOfProducts());
    }
    public class ViewDialog{
        public void showDialog(Activity activity){
            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setContentView(R.layout.layout_dialouge);
            ImageButton exit=(ImageButton) dialog.findViewById(R.id.exit);
            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.cancel();
                }
            });
            Button tryAgain=(Button) dialog.findViewById(R.id.try_again);
            tryAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(activity, "There's a problem is server\n Please try again later", Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                }
            });
            Button back=(Button) dialog.findViewById(R.id.back_to_home);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.cancel();
                }
            });
            dialog.show();

        }
    }
}