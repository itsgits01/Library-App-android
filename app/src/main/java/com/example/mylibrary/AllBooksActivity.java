package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView booksRecView;
    private BooksRecViewAdpater adpater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        adpater= new BooksRecViewAdpater(this);
        booksRecView=findViewById(R.id.booksRecview);

        booksRecView.setAdapter(adpater);
        booksRecView.setLayoutManager(new LinearLayoutManager(this));

        adpater.setBooks(Utils.getInstance().getAllBooks());

    }
}