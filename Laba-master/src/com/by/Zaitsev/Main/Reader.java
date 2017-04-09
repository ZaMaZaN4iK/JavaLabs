package com.by.Zaitsev.Main;

import java.util.ArrayList;
import java.util.concurrent.*;


public class Reader extends Thread{
    public ConcurrentLinkedQueue<Book> list = new ConcurrentLinkedQueue<>();
    public String name;
    public long time;

    public Reader(long time, String name) {
        this.name = name;
        this.time = time;
    }

    public void take(Book book){
        list.add(book);
    }

    @Override
    public void run(){
        try {
            for (Book book : list)
            {
                if (!Library.libList.contains(book) && book.home)
                {
                    System.out.println(name + " ждёт " + book.name);
                    sleep(time);
                }
                if (Library.libList.contains(book))
                {
                    System.out.println(name + " взял " + book.name);
                    Library.libList.remove(book);
                    sleep(book.time);
                    Library.libList.add(book);
                    System.out.println(name + " вернул " + book.name);
                }
                else
                {
                    if (!Library.libList.contains(book) && book.home)
                    {
                        System.out.println(name + " не дождался");
                        stop();
                    }
                    if (!book.home)
                    {
                        System.out.println("Книгу " + book.name + " взяли на дом. " + name + " не стал ждать.");
                    }
                }
            }
        } catch (InterruptedException e) {}
    }
}
