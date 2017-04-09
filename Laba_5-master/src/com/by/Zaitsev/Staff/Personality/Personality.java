package com.by.Zaitsev.Staff.Personality;


public abstract class Personality {

    public String name;
    public String surname;
    public String middleName;
    public byte age;
    public byte day;
    public byte month;
    public byte year;

    abstract public void hello();
    abstract public void goodbye();

    @Override
    public String toString() {
        return "Personality{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", age=" + age +
                '}';
    }
}
