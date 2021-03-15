package com.example.crypto;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.MediaStore;
import android.telephony.emergency.EmergencyNumber;

import java.io.File;
import java.security.acl.Permission;
import java.util.ArrayList;

public class ImageGallery {
    public static ArrayList<String> loi(Context context) {
        Uri uri;
        Cursor cursor;
        int cid, cif;
        ArrayList<String> loi = new ArrayList<>();
        String apath;
        uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

        String[] projection = new String[]{MediaStore.MediaColumns.DATA,
                MediaStore.Video.Media.BUCKET_DISPLAY_NAME};
        String orderBy=MediaStore.Video.Media.DATE_TAKEN;

        cursor = context.getContentResolver().query(uri, projection, null, null, null);

        cid = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);


        // cif=cursor.getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);

        while (cursor.moveToNext()){
            apath = cursor.getString(cid);
            loi.add(apath);
        }
        return loi;


    }

    public static ArrayList<String> lows(Context context){

//        File dcimPath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + "/Camera");
        File dcimPath = new File( "/storage/4C49-8CFE/WhatsApp/Media/.Statuses");
        File[] files = dcimPath.listFiles();
        ArrayList<String> lows = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            String name = files[i].getName();
            lows.add(files[i].getPath());
        }
        return lows;
    }
}

