package com.by.Zaitsev.Main;

import com.by.Zaitsev.Staff.IStaff;

import java.util.Comparator;

public class Compare implements Comparator<IStaff> {
    @Override
    public int compare(IStaff o1, IStaff o2) {
        if (o1.getSalary() > o2.getSalary()){
            return 1;
        }
        else if (o1.getSalary() < o2.getSalary()){
            return -1;
        }
        else return 0;
    }
}
