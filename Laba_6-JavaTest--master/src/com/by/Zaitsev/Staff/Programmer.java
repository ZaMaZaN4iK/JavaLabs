package com.by.Zaitsev.Staff;

import com.by.Zaitsev.Staff.Personality.Personality;
import com.by.Zaitsev.Staff.Personality.Skills;

import java.util.ArrayList;

public class Programmer extends Personality implements IStaff {

    public ArrayList<Skills> skills = new ArrayList<Skills>();
    public Integer salary = null;

    private Programmer() {

    }

    public Programmer(String name, String surname,
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
        System.out.println("----> Hello from Programmer");
    };

    public void goodbye() {
        System.out.println("----> Good Bye from Programmer");
    };

    public void goWork(){
        System.out.println("----> Programmer go to work!");
    };

    public void goHome(){
        System.out.println("----> Programmer go to home!");
    };

    @Override
    public String toString() {
        return "Programmer{" +
                "skills=" + skills +
                ", salary=" + salary + '}';
    }
}
