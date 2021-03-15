package com.example.crypto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Image_Gallery extends AppCompatActivity {

    /** The images. */
    List<String> images,txt2,txt1;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    TextView textView;

    private static final int mrpc=101;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image__gallery);

        textView=findViewById(R.id.txt);
        recyclerView=findViewById(R.id.recycler);


        if (ContextCompat.checkSelfPermission(Image_Gallery.this , Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(Image_Gallery.this , new String[] {
                    Manifest.permission.READ_EXTERNAL_STORAGE}, mrpc);
        }

        else
        {
            loadImages();
        }
    }

    private void loadImages() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        images = ImageGallery.loi(this);
        txt1 = getFileNameFromUrl(images);
        myAdapter = new MyAdapter(this, images,txt1,txt2, new MyAdapter.PhotoListener() {
            @Override
            public void onPhotoClick(String path) {
                Intent i = new Intent(Image_Gallery.this, player.class);
                String v_path = path;
                i.putExtra("videopath" , v_path);
                startActivity(i);
            }
        });

        recyclerView.setAdapter(myAdapter);
        textView.setText("Video("+images.size()+")s");

    }



    public List<String> getFileNameFromUrl(List<String> items) {
        String array[] = new String[items.size()];
        String videoname[] = new String[items.size()];
        for(int j =0;j<items.size();j++){
            array[j] = items.get(j);
        }

        for(int j =0;j<items.size();j++){
            String[] filname = array[j].split("/");
            videoname[j] = filname[filname.length-1];
        }

        String name;
        ArrayList<String> getFileNameFromUrl = new ArrayList<>();
        for(int j =0;j<items.size();j++){
            name = videoname[j];
            getFileNameFromUrl.add(name);

        }
        for(int j =0;j<items.size();j++){
            String[] filname = array[j].split("/");
            videoname[j] = filname[filname.length-1];
        }
        return getFileNameFromUrl;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == mrpc) {
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"RE", Toast.LENGTH_SHORT).show();
                loadImages();

            }
            else{
                Toast.makeText(this,"NRE", Toast.LENGTH_SHORT).show();
            }

        }
    }


}
