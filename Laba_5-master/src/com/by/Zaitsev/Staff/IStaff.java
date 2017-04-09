package com.by.Zaitsev.Staff;
import com.by.Zaitsev.Staff.Personality.Skills;
import java.util.ArrayList;

public interface IStaff {

    void goWork();
    ArrayList<Skills> getSkills();
    Integer getSalary();
    void goHome();
}
