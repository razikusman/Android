package com.example.crypto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import com.nbsp.materialfilepicker.MaterialFilePicker;
//import com.nbsp.materialfilepicker.ui.FilePickerActivity;

import java.util.regex.Pattern;

public class Encrypt extends AppCompatActivity {


    Button button;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);



    /*button = (Button) findViewById(R.id.btn_1);
    textview = (TextView) findViewById(R.id.file_1);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new MaterialFilePicker()
                    // Pass a source of context. Can be:
                    //    .withActivity(Activity activity)
                    //.withFragment(Fragment fragment)
                    //.withSupportFragment(androidx.fragment.app.Fragment fragment)
                    .withActivity(Encrypt.this)
                    // With cross icon on the right side of toolbar for closing picker straight away
                   // .withCloseMenu(true)
                    // Entry point path (user will start from it)
                    //.withPath(Download.absolutePath)
                    // Root path (user won't be able to come higher than it)
                    //.withRootPath(Storage.absolutePath)
                    // Showing hidden files
                    .withHiddenFiles(true)
                    // Want to choose only jpg images
                    //.withFilter(Pattern.compile(".*\\.(jpg|jpeg)$"))
                    // Don't apply filter to directories names
                    //.withFilterDirectories(false)
                    //.withTitle("Sample title")
                    .withRequestCode(1000)
                    .start();
        }
    });*/

    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000 && resultCode == RESULT_OK) {
            String filePath = data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);
            // Do anything with file
            textview.setText(filePath);
        }
    }*/
}
