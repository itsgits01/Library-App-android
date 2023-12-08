package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY="bookId";

    private TextView txtBookName1,txtAuthor1,txtPAges1,txtDescrption1,txtLongDescr1;
    private Button btnWanttoRead,btnFavorite,btnCurrentlyReading,btnAlreadyRead;
    private ImageView bookImage1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

        //Book book1=new Book(1,"IQ84","charles",1087,"Pls read this","Plase read more descripton","https://upload.wikimedia.org/wikipedia/en/b/b9/1Q84bookcover.jpg");


        Intent intent=getIntent();
        if (null!=intent){
            int bookId= intent.getIntExtra(BOOK_ID_KEY,-1);
            if (bookId !=-1){
                Book incomingBook=Utils.getInstance().getBookbyId(bookId);
                if (null!=incomingBook){
                    setData(incomingBook);
                }
            }
        }


    }

    private void setData(Book book1) {
        txtBookName1.setText(book1.getName());
        txtAuthor1.setText(book1.getAuthor());
        txtPAges1.setText(String.valueOf(book1.getPages()));
        txtDescrption1.setText(book1.getShortDesc());
        txtLongDescr1.setText(book1.getLongDesc());

        Glide.with(this)
                .asBitmap().load(book1.getImageUrl())
                .into(bookImage1);
    }

    private void initViews() {
        txtBookName1=findViewById(R.id.txtBookNAme1);
        txtAuthor1=findViewById(R.id.txtAuthor);
        txtPAges1=findViewById(R.id.txtPages1);
        txtDescrption1=findViewById(R.id.txtDescrptn1);
        txtLongDescr1=findViewById(R.id.txtLongdecr1);

        btnWanttoRead=findViewById(R.id.btnWantoRead);
        btnAlreadyRead=findViewById(R.id.btnAddtoAlreadyRead);
        btnCurrentlyReading=findViewById(R.id.btnCurrentlyReading);
        btnFavorite=findViewById(R.id.btnAddtoFAvorite);

        bookImage1=findViewById(R.id.bookImage1);

    }
}