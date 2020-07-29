package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {
    Department department;
    Principal principal;
    Student student;
    Teacher teacher;
    Course SFE101;
    Class aClass;

    @BeforeEach
    void setUp () {
       department = new Department(18, "Software Engineering");
        principal = new Principal("Chibueze",
                "Eziokwubundu", 28, department);
        teacher = new Teacher("David", "Odohi", department, 28);
        Applicant applicant = new Applicant("ujunwa", "odiwa", department, 23);
        student = principal.admitStudent(applicant);

        SFE101 = new Course("Fundamentals of Software Engineering",
                "SFE 101: An intoduction to the fundamentals of Software development. At the" +
                        "end of this course, students should be conversant with core software engineering concepts",
                101L, teacher);
        department.getCourses(principal).put(SFE101.getCourseCode(), SFE101);
    }

    @Test
    void testingGetCourses() {
        assertEquals(0, teacher.getCourses().size(), "should equal 0");
        teacher.addCourse(SFE101);
        assertEquals(1, teacher.getCourses().size(), "should equal 1");

    }

    @Test
    void testingAddCourse() {
        Course course = teacher.addCourse(SFE101);
        assertNotNull(course);
        assertEquals(SFE101.getCourseCode(), course.getCourseCode(), "Should equal 101L");
    }

    @Test
    void testingAddStudentToCourse() {
        assertEquals(0, SFE101.getAllStudents().size(), "should equal 0");
        Course course = teacher.addStudentToCourse(student, SFE101);
        assertNotNull(course);
        assertEquals(SFE101, course);
        assertEquals(1, SFE101.getAllStudents().size(), "should equal 1");
    }

    @Test
    void testingTakeClass() {
        assertEquals(0, SFE101.getClasses().size(), "should equal 0");
        teacher.takeClass(SFE101, 2, LocalTime.of(2, 30));
        assertEquals(1, SFE101.getClasses().size(), "should equal 1");
    }

    @Test
    void addStudentToClass() {
        Class aClass1 = new Class(SFE101, teacher, 2, LocalTime.of(2, 30));
        assertEquals(0, aClass1.getStudentsInAttendance().size(), "should equals 0");
        teacher.addStudentToClass(student, aClass1);
        assertEquals(1, aClass1.getStudentsInAttendance().size(), "should equals 1");
    }
}