package com.by.Zaitsev.Company;

import com.by.Zaitsev.Staff.IStaff;
import java.util.ArrayList;

public class CIB extends ICompany  {

    private CIB(){ }

    public CIB(String nameCompany) {
        super();
        this.name = nameCompany;
    }

    @Override
    public String createProgramm(){
        return new String("SomeProduct");
    }

    @Override
    public ArrayList<IStaff> getStaffs() {
        return this.staff;
    }

    @Override
    public void setStafflist(ArrayList<IStaff> staffList) {
        this.staff.addAll(staffList);
    }

    @Override
    public boolean addStaff(IStaff staff) {
        if (this.staff.add(staff)){
            return true;
        }
        else {
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean removeStaff(IStaff staff) {
        if (this.staff.remove(staff)) {
            return true;
        }
        else {
            throw new IllegalStateException();
        }
    }
}




