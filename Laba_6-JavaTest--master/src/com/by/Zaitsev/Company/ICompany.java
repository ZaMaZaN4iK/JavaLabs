package com.by.Zaitsev.Company;

import com.by.Zaitsev.Staff.IStaff;
import java.util.ArrayList;

public abstract class ICompany{

    public ArrayList<IStaff> staff = new ArrayList<IStaff>();
    public String name = null;

    abstract public String createProgramm();

    abstract public ArrayList<IStaff> getStaffs();

    abstract public void setStafflist(ArrayList<IStaff> staffList);

    abstract public boolean addStaff(IStaff staff);

    abstract public boolean removeStaff(IStaff staff);
}
