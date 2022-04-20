package com.example.Photomanagementsystem;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class home extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Uri> image_uris;
    public home() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.recycle_view);
        String[] Projections = new String[]{
                MediaStore.Images.Media._ID,
                MediaStore.Images.Media.SIZE,
                MediaStore.Images.Media.DATE_MODIFIED
        };
        String Selection = null;
        String[] Selection_args= null;
        String order_by= null;
        Uri content_uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = getActivity().getContentResolver().query(content_uri, Projections, Selection
        , Selection_args, order_by);
        if(cursor != null){
            cursor.moveToPosition(0);
        }
        while (true){
            long id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID));
            Uri image_uri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id);
            image_uris.add(image_uri);
            if(cursor.isLast()){
                break;
            }
            else{
                cursor.moveToNext();
            }
        }
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        return root;
    }
}