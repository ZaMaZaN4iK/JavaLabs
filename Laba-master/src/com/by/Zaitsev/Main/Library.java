package com.by.Zaitsev.Main;

import java.util.ArrayList;
import java.util.concurrent.*;


public class Library {
    public static ConcurrentLinkedQueue<Book> libList = new ConcurrentLinkedQueue<>();

    public boolean add(Book book){
        return  libList.add(book);
    }

    public boolean remove(Book book){
        return libList.remove(book);
    }
}
