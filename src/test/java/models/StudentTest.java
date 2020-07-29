package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Department department;
    Principal principal;
    Student student;
    Student student2;
    Teacher teacher;
    Course SFE101;

    @BeforeEach
    void setUp () {
        Department department = new Department(18, "Software Engineering");
        Principal principal = new Principal("Chibueze",
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
    void testingTakeCourse() {
        teacher.addCourse(SFE101);
        Course course = student.takeCourse(SFE101);
        assertNotNull(course, "should not be null");
        assertEquals(101L, course.getCourseCode(), "should have a course code of 101L");
    }

    @Test
    void testingGetCurrCourses() {
        assertEquals(0, student.getCurrCourses().size(), "should have a size of 1");
        Course course = student.takeCourse(SFE101);
        assertNotNull(student.getCurrCourses(), "should not be null");
        assertNotNull(course, "should not be null");
        assertEquals(1, student.getCurrCourses().size(), "should have a size of 1");
        assertTrue(student.getCurrCourses().containsKey(101L), "should contain a key 101L");
    }

    @Test
    void testingGetRole() {
        assertEquals(Role.STUDENT, student.getRole(), "should have a role of STUDENT");
    }
}