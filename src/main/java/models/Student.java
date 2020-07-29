package models;

import java.util.HashMap;
import java.util.Map;

public class Student extends Person {
    private Map<Long, Course> currCourses = new HashMap<>();
    Role role = Role.STUDENT;

    public Student(String firstName, String lastName, Department department, int age) {
        super(firstName,lastName, department, age);
    }

    /**
     * Takes in a course and tries to add a student to the list of students taking that course
     * It calls the course.getTeacher() method, as it is only a teacher that can approve the
     * students taking his/her course
     * if it fails it prints an error message and returns null, else it returns the course;
     * @param course
     * @return Course
     */
    public Course takeCourse (Course course) {
           Course course1 = course.getTeacher().addStudentToCourse(this, course);
           if (course1 == null) {
               System.out.println("You cannot take this course!!");
               return null;
           }
            currCourses.put(course.getCourseCode(), course);
            return course;
    }


    /**
     * getCurrCourses returns the list of current courses currently offered by the student
     * @return
     */
    public Map<Long, Course> getCurrCourses () {
        return currCourses;
    }

    @Override
    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("position: %s%n", getRole());
    }
}

