package models;

public abstract class Person implements ID {
    private String firstName;
    private String lastName;
    private Department department;
    private int age;
    private Long id;
    private static Long currId = 100L;

    public Person(String firstName, String lastName, Department department, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.age = age;
        this.id = nextId();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getFullName() {
        return String.format("%s %s", getFirstName(), getLastName());
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public Department getDepartment() {
        return department;
    }

    private Long nextId() {
        currId++;
        return currId;
    }

    @Override
    public String toString() {
        return String.format("name: %s%n" +
                "id: %s%n" +
                "age: %s%n" +
                "dept: %s%n", getFullName(), getId(), getAge(), getDepartment().getName());
    }
}
