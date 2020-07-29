package models;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Department {
    private String name;
    private Principal principal;
    private static int MINIMUM_AGE;
    private Map<Long, Student> students = new HashMap<>();
    private Map<Long, Course> courses = new HashMap<>();
    private Map<Long, Staff> staff = new HashMap<>();
    private Map<Long, Applicant> applicants = new HashMap<>();

    public Department (int minimum_age, String name) {
        MINIMUM_AGE = minimum_age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public static int getMinimumAge() {
        return MINIMUM_AGE;
    }

    public static void setMinimumAge(int minimumAge) {
        MINIMUM_AGE = minimumAge;
    }



    public Map<Long, Student> getStudents(Person person) {
        if (person.getRole() != Role.PRINCIPAL) {
            System.out.println("You do no have required permissions!!");
            return null;
        }
        return students;
    }

    public Set<Student> getStudents() {
        Set<Student> studentsSet = new HashSet<>();
        students.values().forEach(studentsSet::add);
        return studentsSet;
    }

    public Map<Long, Course> getCourses(Person person) {
        if (person.getRole() != Role.PRINCIPAL) {
            System.out.println("You do no have required permissions!!");
            return null;
        }
        return courses;
    }

    public Set<Course> getCourses() {
        Set<Course> coursesSet = new HashSet<>();
        courses.values().forEach(coursesSet::add);
        return coursesSet;
    }

    public Map<Long, Staff> getStaff(Person person) {
        if (person.getRole() != Role.PRINCIPAL) {
            System.out.println("You do no have required permissions!!");
            return null;
        }
        return staff;
    }

    public Set<Staff> getStaff() {
        Set<Staff> staffSet = new HashSet<>();
        staffSet.addAll(staff.values());
        return staffSet;
    }

    public Map<Long, Applicant> getApplicants(Person person) {
        if (person.getRole() != Role.PRINCIPAL) {
            System.out.println("You do no have required permissions!!");
            return null;
        }
        return applicants;
    }

    public Set<Applicant> getApplicants() {
        Set<Applicant> applicantsSet = new HashSet<>();
        applicantsSet.addAll(applicants.values());
        return applicantsSet;
    }

    @Override
    public String toString() {
        return String.format(
                "Welcome to %s Department: We are a dedicated team of over %s staff with %s students under admission. " +
                        "There are %s course(s) offered and %s applicant(s) under review.",
                getName(),
                getStaff().size(),
                getStudents().size(),
                getCourses().size(),
                getApplicants().size()
        );
    }
}
