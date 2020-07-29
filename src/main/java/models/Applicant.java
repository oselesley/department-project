/**
 * Applicant.java:
 * A class to model an applicant applying to a department
*/

package models;

public class Applicant extends Person{
    private Role role = Role.APPLICANT;
    public Applicant(String firstName, String lastName, Department department, int age) {
        super(firstName, lastName, department, age);
    }

    @Override
    public Role getRole() {
        return role;
    }
}
