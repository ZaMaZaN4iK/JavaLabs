package com.by.Zaitsev.Staff;

import com.by.Zaitsev.Staff.Personality.Personality;
import com.by.Zaitsev.Staff.Personality.Skills;

import java.util.ArrayList;

public class SystemAdmin extends Personality implements IStaff {

    public ArrayList<Skills> skills = new ArrayList<Skills>();
    public Integer salary = null;

    private SystemAdmin() {

    }

    public SystemAdmin(String name, String surname,
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
        System.out.println("----> Hello from SystemAdmin");
    };

    public void goodbye() {
        System.out.println("----> Good Bye from SystemAdmin");
    };

    public void goWork(){
        System.out.println("----> SystemAdmin go to work!");
    };

    public void goHome(){
        System.out.println("----> SystemAdmin go to home!");
    };

    @Override
    public String toString() {
        return "SystemAdmin{" +
                "skills=" + skills +
                ", salary=" + salary + '}';
    }
}
