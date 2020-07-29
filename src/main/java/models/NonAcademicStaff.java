package models;


public class NonAcademicStaff extends Staff{
    public NonAcademicStaff(String firstName, String lastName, Department department, int age) {
        super("nas", firstName, lastName, department, age);
    }
}

