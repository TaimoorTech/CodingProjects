package com.example.dbms_cs031_cs010_cs006_cs008;

import static androidx.recyclerview.widget.LinearLayoutManager.VERTICAL;

import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.navigation.NavigationView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link tvFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tvFragment extends Fragment {
    ArrayList<String> names =  new ArrayList<>();
    ArrayList<String> prices =  new ArrayList<>();
    ArrayList<String> detailed_information =  new ArrayList<>();
    ArrayList<Float> rate =  new ArrayList<>();
    ArrayList<Bitmap> bitmapArrayList = new ArrayList<>();
    ArrayList<Bitmap> bitmapArrayList_edited = new ArrayList<>();
    RecyclerView electronic_items_recycler;
    NavigationView navigation;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public tvFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tvFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static tvFragment newInstance(String param1, String param2) {
        tvFragment fragment = new tvFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
    public void onResume() {

        super.onResume();

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){

                    // handle back button
                    Menu drawer_menu = navigation.getMenu();
                    MenuItem menuItem;
                    menuItem = drawer_menu.findItem(R.id.tv);
                    menuItem.setChecked(false);
                    getActivity().onBackPressed();
                    return true;

                }

                return false;
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tv, container, false);
        electronic_items_recycler = view.findViewById(R.id.Electronic_items_Recycle_tv);

        navigation = (NavigationView)getActivity().findViewById(R.id.navigation_view);
        Menu drawer_menu = navigation.getMenu();
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

        if(!menuItem1.isChecked())
        {
            menuItem1.setChecked(true);
        }

        AssetManager assetManager = getContext().getAssets();
        Bitmap bitmap = null;
        Bitmap bitmap_edited = null;

        try {
            String[] imgPath= assetManager.list("tv_images");
            String[] imgPath1 = assetManager.list("tv_imagesedited");
            for (int i=0; i<imgPath.length; i++){
                InputStream is = assetManager.open("tv_images/"+imgPath[i]);
                bitmap = BitmapFactory.decodeStream(is);
                bitmapArrayList.add(bitmap);

                InputStream is1 = assetManager.open("tv_imagesedited/"+imgPath1[i]);
                bitmap_edited = BitmapFactory.decodeStream(is1);
                bitmapArrayList_edited.add(bitmap_edited);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        database_access get_name = database_access.getInstance(container.getContext(), "tv_informations.db");

        get_name.open_db();

        Cursor row = get_name.getInfo();

        while(row.moveToNext()){
            names.add(row.getString(0));
            detailed_information.add(row.getString(1));
            rate.add(Float.valueOf(row.getString(2)));
            prices.add(row.getString(3));
        }

        get_name.close_db();


        Electronics_Items_Recycler_Adapter adapter = new Electronics_Items_Recycler_Adapter(container.getContext(),
                names, bitmapArrayList, rate, prices, detailed_information, bitmapArrayList_edited);
        adapter.filter(container.getContext(), bitmapArrayList, names, rate, prices, detailed_information, bitmapArrayList_edited);
        GridLayoutManager gridLayoutManager =  new GridLayoutManager(getContext(), 2, VERTICAL, false);
        electronic_items_recycler.setLayoutManager(gridLayoutManager);
        electronic_items_recycler.setHasFixedSize(true);
        electronic_items_recycler.setAdapter(adapter);

        return view;
    }
}