package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    Teacher teacher;
    Department department;
    Principal principal;
    Course course;
    Student student;
    Applicant applicant;
    Class aClass;

    @BeforeEach
    void setUp() {
        department = new Department(18, "Software Engineering");

        principal = new Principal("Chibueze",
                "Eziokwubundu", 28, department);
        teacher = new Teacher("Gadibia", "Oghenetevwodaro", department, 27);
        course = new Course("Fundamentals of Software Engineering",
                "SFE 101: An intoduction to the fundamentals of Software development. At the" +
                        "end of this course, students should be conversant with core software engineering concepts",
                101L, teacher);

        department.getCourses(principal).put(course.getCourseCode(), course);
        teacher.addCourse(course);
        applicant = new Applicant("ujunwa", "odiwa", department, 23);
        student = principal.admitStudent(applicant);
        aClass = new Class(course, teacher, 2, LocalTime.of(2, 30));


    }

    @Test
    void testingGetCourseName() {
        assertEquals("Fundamentals of Software Engineering", course.getCourseName(), "should equal 'Fundamentals of Software Engineering'");
    }

    @Test
    void testingAddStudent() {
        Student student1 = course.addStudent(student, principal);
        assertNotNull(student1, "should not be null");
        assertEquals("ujunwa odiwa", student1.getFullName(), "should equal ujunwa odiwa");
        assertEquals(1, course.getAllStudents().size());
    }

    @Test
    void testingDoNotAddStudent() {
        Student student1 = course.addStudent(student, student);
        assertNull(student1, "should be null");
        assertEquals(0, course.getAllStudents().size(), "should equal 0");
    }

    @Test
    void testingRemoveStudent() {
        Student student1 = course.addStudent(student, principal);
        assertEquals(student1, course.removeStudent(student1.getId()), "should equal student");
    }

    @Test
    void testingGetStudent() {
        Student student1 = course.addStudent(student, principal);
        assertNotNull(student1, "should not be null");
        assertEquals(student1, student, "should equal student");
    }

    @Test
    void testingGetAllStudents() {
        assertNotNull(course.getAllStudents());
        assertEquals(0, course.getAllStudents().size(), "should equal 0");
        Student student1 = course.addStudent(student, principal);
        assertEquals(1, course.getAllStudents().size(), "should equal student");
    }

    @Test
    void addClass() {
        Class aClass1 = course.addClass(aClass);
        assertNotNull(aClass1, "should not be null");
        assertEquals(aClass1, aClass, "should equal aClass");
    }

    @Test
    void getClasses() {
        assertEquals(0, course.getClasses().size(), "should equal 0");
        Class aClass1 = course.addClass(aClass);
        assertNotNull(course.getClasses(), "shouldnt be null");
        assertEquals(1, course.getClasses().size(), "should equal 1");
    }
}