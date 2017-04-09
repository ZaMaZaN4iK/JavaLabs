package com.by.Zaitsev.HomeLibrary;


public class Author {

    public int ID;
    public String Name;
    public String SecondName;
    public String LastName;

    @Override
    public String toString() {
        return '\n' + "Author{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", SecondName='" + SecondName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }
}
