package com.by.Zaitsev.Staff.Director;


import com.by.Zaitsev.Company.ICompany;
import com.by.Zaitsev.Staff.IStaff;
import com.by.Zaitsev.Staff.Personality.Personality;
import com.by.Zaitsev.Staff.Personality.Skills;

import java.util.ArrayList;
import java.util.Collections;

public class Director extends Personality implements IStaff {

    public ArrayList<Skills> skills = new ArrayList<Skills>();
    public Integer salary = null;

    public ArrayList<Skills> getSkills() {
        return this.skills;
    }
    public Integer getSalary() {
        return this.salary;
    }

    public ArrayList<ICompany> companies = new ArrayList<ICompany>();

    private Director() {

    }

    private static Director ourInstance = new Director();

    public static Director getInstance() {
        return ourInstance;
    }

    public void countStaff(ICompany companyany) {
        ICompany suchCompany = companies.get(companies.indexOf(companyany));
    }

    public boolean searchStaffWithSkills(ICompany company, Skills... skills) {
        ICompany suchCompany = companies.get(companies.indexOf(company));
        for (IStaff staff : suchCompany.staff) {
            for (Skills skill : skills) {
                if (staff.getSkills().contains(skill)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void sortStaff(ICompany company){
        ICompany suchCompany = companies.get(companies.indexOf(company));
        Collections.sort(suchCompany.getStaffs(),
                (a,b) -> Integer.compare(Integer.valueOf(a.getSalary()), Integer.valueOf(b.getSalary())));
    }

    public void hello() {
        System.out.println("----> Hello from Director");
    };

    public void goodbye() {
        System.out.println("----> Good Bye from Director");
    };

    public void goWork(){
        System.out.println("----> Director go to work!");
    };

    public void goHome(){
        System.out.println("----> Director go to home!");
    };


    @Override
    public String toString() {
        return "Director{" +
                "skills=" + skills +
                ", salary=" + salary +
                ", companies=" + companies +
                '}';
    }
}
