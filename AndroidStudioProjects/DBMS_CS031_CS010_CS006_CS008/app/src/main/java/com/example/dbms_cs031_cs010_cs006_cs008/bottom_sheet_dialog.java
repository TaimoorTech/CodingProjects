package com.example.dbms_cs031_cs010_cs006_cs008;

import android.app.Dialog;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link bottom_sheet_dialog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class bottom_sheet_dialog extends BottomSheetDialogFragment {
    ArrayList<Bitmap> images_arrayList = new ArrayList<>();
    ArrayList<String> names_arrayList = new ArrayList<>();
    ArrayList<String> prices_arrayList = new ArrayList<>();
    ArrayList<Float> rate_arrayList = new ArrayList<>();
    ArrayList<String> quantity_arrayList = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public bottom_sheet_dialog() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment bottom_sheet_dialog.
     */
    // TODO: Rename and change types and number of parameters
    public static bottom_sheet_dialog newInstance(String param1, String param2) {
        bottom_sheet_dialog fragment = new bottom_sheet_dialog();
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        order_database getting = new order_database(getContext());
        Cursor row = getting.get_info();
        while (row.moveToNext()){
            names_arrayList.add(row.getString(1));
            rate_arrayList.add(Float.valueOf(row.getString(3)));
            prices_arrayList.add(row.getString(6));
            quantity_arrayList.add(row.getString(5));
            byte[] img = row.getBlob(7);
            Bitmap item_image = BitmapFactory.decodeByteArray(img, 0, img.length);
            images_arrayList.add(item_image);
        }
        setStyle(STYLE_NORMAL, com.google.android.material.R.style.Animation_Design_BottomSheetDialog);

        RecyclerView last_screen_recycler = view.findViewById(R.id.bottom_sheet_fragment_recycler);
        cart_last_screen_recycler adapter = new cart_last_screen_recycler(getContext(),
                names_arrayList, images_arrayList, rate_arrayList, prices_arrayList, quantity_arrayList);
        adapter.filter(getContext(),
                names_arrayList, images_arrayList, rate_arrayList, prices_arrayList, quantity_arrayList);
        last_screen_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        last_screen_recycler.setAdapter(adapter);

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bottom_sheet_dialog, null);
        bottomSheetDialog.setContentView(view);

//        order_database getting = new order_database(getContext());
//        Cursor row = getting.get_info();
//        while (row.moveToNext()){
//            names_arrayList.add(row.getString(1));
//            rate_arrayList.add(Float.valueOf(row.getString(3)));
//            prices_arrayList.add(row.getString(6));
//            quantity_arrayList.add(row.getString(5));
//            byte[] img = row.getBlob(7);
//            Bitmap item_image = BitmapFactory.decodeByteArray(img, 0, img.length);
//            images_arrayList.add(item_image);
//        }
//
//        RecyclerView last_screen_recycler = view.findViewById(R.id.bottom_sheet_fragment_recycler);
//        cart_last_screen_recycler adapter = new cart_last_screen_recycler(getContext(),
//                names_arrayList, images_arrayList, rate_arrayList, prices_arrayList, quantity_arrayList);
//        adapter.filter(getContext(),
//                names_arrayList, images_arrayList, rate_arrayList, prices_arrayList, quantity_arrayList);
//        last_screen_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
//        last_screen_recycler.setAdapter(adapter);
//
//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
//        last_screen_recycler.addItemDecoration(itemDecoration);

        return bottomSheetDialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_sheet_dialog, container, false);

//        order_database getting = new order_database(container.getContext());
//        Cursor row = getting.get_info();
//        while (row.moveToNext()){
//            names_arrayList.add(row.getString(1));
//            rate_arrayList.add(Float.valueOf(row.getString(3)));
//            prices_arrayList.add(row.getString(6));
//            quantity_arrayList.add(row.getString(5));
//            byte[] img = row.getBlob(7);
//            Bitmap item_image = BitmapFactory.decodeByteArray(img, 0, img.length);
//            images_arrayList.add(item_image);
//        }

//        RecyclerView last_screen_recycler = view.findViewById(R.id.bottom_sheet_fragment_recycler);
//        cart_last_screen_recycler adapter = new cart_last_screen_recycler(container.getContext(),
//                names_arrayList, images_arrayList, rate_arrayList, prices_arrayList, quantity_arrayList);
//        adapter.filter(container.getContext(),
//                names_arrayList, images_arrayList, rate_arrayList, prices_arrayList, quantity_arrayList);
//        last_screen_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
//        last_screen_recycler.setAdapter(adapter);

        return view;
    }
}