package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {
    Teacher teacher;
    Principal principal;
    Student student;
    Department department;
    Course SFE101;
    Applicant applicant;


    @BeforeEach
    void setUp () {
        department = new Department(18, "Software Engineering");
        principal = new Principal("Chibueze",
                "Eziokwubundu", 28, department);
        teacher = new Teacher("David", "Odohi", department, 28);
        applicant = new Applicant("ujunwa", "odiwa", department, 23);
        student = principal.admitStudent(applicant);

        SFE101 = new Course("Fundamentals of Software Engineering",
                "SFE 101: An intoduction to the fundamentals of Software development. At the" +
                        "end of this course, students should be conversant with core software engineering concepts",
                101L, teacher);
        department.getCourses(principal).put(SFE101.getCourseCode(), SFE101);
    }

    @Test
    void testingGetStudents() {
        Applicant applicant2 = new Applicant("fred", "chinazor", department, 25);
        assertNull(department.getStudents(student), "should be null");
        Map<Long, Student> students1= department.getStudents(principal);
        assertNotNull(students1);
        assertEquals(1, students1.size(), "should equal 1");
        principal.admitStudent(applicant2);
        assertEquals(2, students1.size(), "should equal 2");

    }

    @Test
    void testGetCourses() {
        assertEquals(1, department.getCourses().size(), "should equal 1");
    }

    @Test
    void testGetStaff() {
        assertEquals(0, department.getStaff().size(), "should equal 0");
        department.getStaff(principal).put(teacher.getId(), teacher);
        assertEquals(1, department.getStaff().size(), "should equal 0");
    }

    @Test
    void testGetApplicants() {
        assertEquals(0, department.getApplicants().size(), "should equal 0");
        department.getApplicants(principal).put(applicant.getId(), applicant);
        assertEquals(1, department.getApplicants().size(), "should equal 1");
    }
}