package com.by.Zaitsev.HomeLibrary;

import java.util.Date;


public class Books
{

    public int ID;
    public int AuthorID;
    public String Name;
    public Date date;
    public String Izd;

    @Override
    public String toString() {
        return  '\n' + "Books{" +
                "ID=" + ID +
                ", AuthorID=" + AuthorID +
                ", Name='" + Name + '\'' +
                ", date=" + date +
                ", Izd='" + Izd + '\'' +
                '}';
    }
}
