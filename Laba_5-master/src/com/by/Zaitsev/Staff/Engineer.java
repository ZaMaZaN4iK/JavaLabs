package com.by.Zaitsev.Staff;

import com.by.Zaitsev.Staff.Personality.Personality;
import com.by.Zaitsev.Staff.Personality.Skills;

import java.util.ArrayList;

public class Engineer extends Personality implements IStaff {

    public ArrayList<Skills> skills = new ArrayList<Skills>();
    public Integer salary = null;

    public Engineer() {

    }

    public Engineer(String name, String surname,
                    String middleName, byte age) {
        this.name = name;
        this.middleName = middleName;
        this.surname = surname;
        this.age = age;
    }

    public ArrayList<Skills> getSkills() {
        return this.skills;
    }
    public Integer getSalary() {
        return this.salary;
    }

    public void hello() {
        com.by.Zaitsev.Main.Main.LOG.info("----> Hello from Engineer");
    };

    public void goodbye() {
        com.by.Zaitsev.Main.Main.LOG.info("----> Good Bye from Engineer");
    };

    public void goWork(){
        com.by.Zaitsev.Main.Main.LOG.info("----> Engineer go to work!");
    };

    public void goHome(){
        com.by.Zaitsev.Main.Main.LOG.info("----> Engineer go to home!");
    };

    @Override
    public String toString() {
        return "Engineer{" +
                "skills=" + skills +
                ", salary=" + salary +
                '}';
    }
}
