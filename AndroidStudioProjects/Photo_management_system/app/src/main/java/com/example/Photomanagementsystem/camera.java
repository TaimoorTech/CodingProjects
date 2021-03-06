package com.example.Photomanagementsystem;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import javax.xml.transform.Result;

public class camera extends Fragment {

    ImageView camera_img;
    Button opening_camera_button;
    private final int CAMERA_REQUEST_CODE = 100;

    public camera() {
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
        View root = inflater.inflate(R.layout.fragment_camera, container, false);

        camera_img = (ImageView) root.findViewById(R.id.camera_upload_image);
        opening_camera_button = (Button) root.findViewById(R.id.open_camera);

        opening_camera_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opn_cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(opn_cam, CAMERA_REQUEST_CODE);
            }
        });
        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (requestCode == CAMERA_REQUEST_CODE){
                Bitmap img = (Bitmap) (data.getExtras().get("data"));
                camera_img.setImageBitmap(img);
            }
        }
    }
}