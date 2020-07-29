package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrincipalTest {
    Department department;
    Principal principal;
    Student student1;
    Student student2;
    Applicant applicant1;
    Applicant applicant2;
    Applicant applicant3;

    @BeforeEach
    void setUp () {
        department = new Department(18, "Software Engineering");
        principal = new Principal("Chibueze",
                "Eziokwubundu", 28, department);

        department.setPrincipal(principal);
        applicant1 = new Applicant("ujunwa", "odiwa", department, 23);
        applicant2 = new Applicant("fred", "chinazor", department, 25);
        applicant3 = new Applicant("kenechukwu", "michael", department, 26);
    }

    @Test
    void testingExpelStudent() throws NotAllowedException {
        student1 = principal.admitStudent(applicant1);
        Student student = principal.expelStudent(student1);
        assertNotNull(student, "should not be null");
        assertEquals(student, student1, "should equal student");
    }

    @Test
    void testingAdmitStudent() {
        Student student = principal.admitStudent(applicant1);
        assertNotNull(student, "should not be null");
        assertEquals(student.getFullName(), applicant1.getFullName(), "should equal 'ujuwa odiwa'");
        assertEquals(0, department.getApplicants(principal).values().size(), "should have a size of 0");
        assertEquals(1, department.getStudents(principal).values().size(), "should have a size of 1");
    }

    @Test
    void testingAdmitStudentLessThan18() throws NotAllowedException {
        applicant1.setAge(17);
        Student student = principal.admitStudent(applicant1);
        assertNull(student, "should be null");
    }

    @Test
    void testingAddStaff() {
        Teacher teacher = new Teacher("David", "Odohi", department, 28);
        Teacher teacher1 = (Teacher) principal.addStaff(teacher);
        assertNotNull(teacher1,  "should not be null");
        assertEquals(teacher1, teacher, "should equal teacher1");
    }

}