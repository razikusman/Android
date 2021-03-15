package com.example.crypto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.crypto.R;

public class MainActivity extends AppCompatActivity {

    private static final int mrpc=101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(MainActivity.this , Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(MainActivity.this , new String[] {
                    Manifest.permission.READ_EXTERNAL_STORAGE}, mrpc);
        }

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1001);
        }

        final ImageButton imageButtongal = findViewById(R.id.img_btngal);
        final ImageButton imageButtonvlt = findViewById(R.id.imag_btnvlt);
        final ImageButton imageButtonen = findViewById(R.id.btn_encrypt);
        final ImageButton imageButtondec = findViewById(R.id.btn_dcrypt);
        final ImageButton imageButtonpload = findViewById(R.id.btn_pload);
        final ImageButton imageButtonpdec = findViewById(R.id.btn_pdec);

        imageButtongal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Payload_imageIntent = new Intent(MainActivity.this , Image_Gallery.class);
                startActivity(Payload_imageIntent);
            }
        });

        imageButtonvlt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent VaultIntent = new Intent(MainActivity.this , Vault.class);
               startActivity(VaultIntent);
            }
        });

        imageButtonen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent EncryptIntent = new Intent(MainActivity.this , Encrypt.class);
                startActivity(EncryptIntent);
            }
        });

        imageButtondec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent decryptIntent = new Intent(MainActivity.this , Decrypt.class);
                startActivity(decryptIntent);
            }
        });

        imageButtonpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PayloadIntent = new Intent(MainActivity.this , Payload_Image.class);
                startActivity(PayloadIntent);
            }
        });

        imageButtonpdec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Payload_decryptIntent = new Intent(MainActivity.this , Payload_decrypt.class);
                startActivity(Payload_decryptIntent);
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        switch(requestCode){
            case 1001:{
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permission Granted!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, "Permission Not Granted!", Toast.LENGTH_SHORT).show();
                    finish();

                }
            }
        }
    }
}
