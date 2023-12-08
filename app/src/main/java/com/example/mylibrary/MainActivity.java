package com.example.mylibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnAllBooks, btnAlreadyRead, btnWantRead, btnCurrentlyReading, btnFavourite, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initviews();

        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(intent);
                v.performHapticFeedback(HapticFeedbackConstants.CONFIRM);


            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("Hello this app is about storing books online classifying them and sorting them." +
                        " Use app wisely and keep visiting");
                builder.setNegativeButton("dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //TO DO:
                        Intent intent= new Intent(MainActivity.this,WebsiteActivity.class);
                        startActivity(intent);
                        v.performHapticFeedback(HapticFeedbackConstants.CONFIRM);
                    }
                });

                builder.create().show();
            }
        });
    }

    private void initviews() {
        btnAllBooks=findViewById(R.id.btnAllBooks);
        btnAlreadyRead=findViewById(R.id.btnAlreadyRead);
        btnWantRead=findViewById(R.id.btnWantRead);
        btnCurrentlyReading=findViewById(R.id.btnCurrentlyReading);
        btnFavourite=findViewById(R.id.btnFavouriteBooks);
        btnAbout=findViewById(R.id.btnAbout);
    }
}