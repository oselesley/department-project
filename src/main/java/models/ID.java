package models;

public interface ID {
    Long getId();
    void setFirstName(String firstName);
    String getFirstName();
    void setLastName(String lastName);
    String getLastName();
    String getFullName();
    void setAge(int age);
    int getAge();
    void setDepartment(Department department);
    Department getDepartment();
    Role getRole();
}
