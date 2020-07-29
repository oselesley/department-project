package models;


public abstract class Staff extends Person {
    private Role role;

    public Staff(String role, String firstName, String lastName, Department department, int age)  {
        super(firstName, lastName, department, age);
        this.role = assignRole(role);
    }

    private Role assignRole(String role) {
        switch (role.toLowerCase()) {
            case "principal": case "p": return Role.PRINCIPAL;
            case "teacher": case "t": return Role.TEACHER;
            default: return Role.NAS;
        }
    }

    @Override
    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("position: %s", getRole());
    }
}

