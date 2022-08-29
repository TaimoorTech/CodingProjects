package com.example.dbms_cs031_cs010_cs006_cs008;

import static androidx.recyclerview.widget.GridLayoutManager.*;

import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    Animation key_a,mouse_a,tv_a;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {

        super.onResume();

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){

                    // handle back button
                    getActivity().finishAffinity();
                    getActivity().finish();
                    System.exit(0);
                    return true;

                }

                return false;
            }
        });
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        NavigationView navigationView = getActivity().findViewById(R.id.navigation_view);


        Menu drawer_menu = navigationView.getMenu();
        MenuItem menuItem;
        menuItem = drawer_menu.findItem(R.id.home);
        MenuItem menuItem1 = drawer_menu.findItem(R.id.tv);
        MenuItem menuItem2 = drawer_menu.findItem(R.id.keyboard);
        MenuItem menuItem3 = drawer_menu.findItem(R.id.mouse);
        MenuItem menuItem4 = drawer_menu.findItem(R.id.about_us);

        menuItem.setChecked(false);
        menuItem1.setChecked(false);
        menuItem2.setChecked(false);
        menuItem3.setChecked(false);
        menuItem4.setChecked(false);


        if(!menuItem.isChecked())
        {
            menuItem.setChecked(true);
        }

        key_a = AnimationUtils.loadAnimation(getContext(), R.anim.stretch);
        mouse_a = AnimationUtils.loadAnimation(getContext(), R.anim.stretch1);
        tv_a = AnimationUtils.loadAnimation(getContext(), R.anim.stretch2);

        CardView keyboard_card = view.findViewById(R.id.keyboard_card);
        CardView mouse_card = view.findViewById(R.id.mouse_card);
        CardView tv_card = view.findViewById(R.id.tv_card);

        keyboard_card.setAnimation(key_a);
        mouse_card.setAnimation(mouse_a);
        tv_card.setAnimation(tv_a);

        keyboard_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout,new Keyboard_Fragment()).addToBackStack(null).commit();
                navigationView.setCheckedItem(R.id.keyboard);

            }
        });
        mouse_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout,new MouseFragment()).addToBackStack(null).commit();
                navigationView.setCheckedItem(R.id.mouse);
            }
        });
        tv_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout,new tvFragment()).addToBackStack(null).commit();
                navigationView.setCheckedItem(R.id.tv);
            }
        });
        return view;
    }
}