package com.example.mylibrary;

import java.util.ArrayList;

public class Utils {

    private static Utils instance;



    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> currentlyReadings;
    private static ArrayList<Book> favoriteBooks;

    private Utils() {
        if (null==allBooks){
            allBooks=new ArrayList<>();
            initData();
        }
        if (null==alreadyReadBooks){
            alreadyReadBooks=new ArrayList<>();
        }
        if (null==wantToReadBooks){
            wantToReadBooks=new ArrayList<>();
        }
        if (null==currentlyReadings){
            currentlyReadings=new ArrayList<>();
        }
        if (null==favoriteBooks){
            favoriteBooks=new ArrayList<>();
        }

    }

    private void initData() {
        //TODO: Add intial Data
        ArrayList<Book> books= new ArrayList<>();
        allBooks.add(new Book(1,"IQ84","charles",1087,"Pls read this","Plase read more descripton",
                "https://upload.wikimedia.org/wikipedia/en/b/b9/1Q84bookcover.jpg"));
        allBooks.add(new Book(2,"Monk Sold","Robin Sharma",150,"Read to get Motivated","read More and more"
                ,"https://m.media-amazon.com/images/I/61Iz2yy2CKL.jpg"));

    }

    public static Utils getInstance() {
        if (null!=instance){
            return instance;
        }else {
            instance=new Utils();
            return instance;
        }
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadings() {
        return currentlyReadings;
    }

    public static ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public Book getBookbyId(int id){
        for (Book b: allBooks){
            if (b.getId()==id){
                return b;
            }
        }

        return null;
    }
}
