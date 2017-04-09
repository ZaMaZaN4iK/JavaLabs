package com.by.Zaitsev.Company;

import com.by.Zaitsev.Staff.Director.Director;
import com.by.Zaitsev.Staff.IStaff;
import com.by.Zaitsev.Staff.Personality.Skills;
import com.by.Zaitsev.Staff.Programmer;
import com.by.Zaitsev.Staff.SystemAdmin;
import org.testng.Assert;
import org.testng.annotations.*;

public class CIBTest {

    private CIB CIB = new CIB("CIB Company");

    @DataProvider(name = "test")
    public Object[][] newData() {
        return new Object[][] {
                { new Programmer("Sashko", "Zaitsev", "zamazan4ik", (byte)19)}
        };
    }

    //аннотированный метод будет запускаться после всех уже запущенных тестовых методов
    @BeforeTest
    public void beforeTest()
    {
        System.out.println("BeforeTest");
    }

    //аннотированный метод будет запущен до любого тестового метода, принадлежащих классам внутри тега <test>
    @AfterTest
    public void afterTest()
    {
        System.out.println("AfterTest");
    }

    //указывает, что метод будет выполнен после запуска тестового класса, но перед всеми тестовыми методами
    @BeforeClass
    public void endTests()
    {
        System.out.println("BeforeClass");
    }

    //аннотированный метод будет запущен после всех тестовых методов в текущем классе
    @AfterClass
    public void startTests()
    {
        System.out.println("AfterClass");
    }

    //указывает, что данный метод, будет запускаться перед любым методом тестового класса
    @BeforeSuite
    public void startTestMethod()
    {
        System.out.println("BeforeSuite");
    }

    //указывает, что данный метод, будет запускаться после всех методом тестового класса
    @AfterSuite
    public void  endTestMethod()
    {
        System.out.println("AfterSuite");
    }

    //аннотированный метод будет выполняться перед каждым тестовым методом
    @BeforeMethod
    public void setUp() throws Exception {
        System.out.println("BeforeMethod");
    }

    //аннотированный метод будет запускаться после каждого тестового метода
    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("AfterMethod");
    }

    @Test(dataProvider = "test")
    public void testAddStaff1(IStaff staff) throws Exception {
        CIB.addStaff(staff);
        Assert.assertTrue(CIB.staff.contains(staff));
    }

    @Test(groups = "GroupFirst")
    public void testCreateProgramm() throws Exception {
        System.out.println("FirstGroupTest");
    }

    @Test(groups = "GroupFirst")
    public void testGetStaffs() throws Exception {
        System.out.println("FirstGroupTest");
    }

    @Test(groups = "GroupSecond")
    public void testSetStafflist() throws Exception {
        System.out.println("SecondGroupTest");
    }

    @Test(groups = "GroupSecond")
    public void testAddStaff() throws Exception {
        System.out.println("SecondGroupTest");
    }

    @Test(dependsOnMethods = {"testAddStaff1"}, dataProvider = "test")
    public void testRemoveStaff(IStaff staff) throws Exception {
        CIB.addStaff(staff);
        CIB.removeStaff(staff);
        Assert.assertFalse(CIB.staff.contains(staff));
    }

    @Test(timeOut = 1)
    public void testCreateProgramm1() throws Exception {
        //Thread.sleep(1000);
        Assert.assertNotNull(CIB.createProgramm());
    }

    @Test
    public void testNew() {
        Programmer programmer = new Programmer(
                "Sashko", "Zaitsev", "zamazan4ik", (byte)19);
        programmer.skills.add(Skills.English);
        programmer.skills.add(Skills.C_plus_plus);
        programmer.salary = 460;

        CIB.addStaff(programmer);

        Director director = Director.getInstance();
        director.companies.add(CIB);
        Assert.assertTrue(director.searchStaffWithSkills(CIB, Skills.English));
    }

    @Test(enabled = false)
    public void testGetStaffs__() throws Exception {
        Assert.fail("No test method");
    }

    @Test(enabled = false)
    public void testSetStafflist__() throws Exception {
        Assert.fail("No test method");
    }
}