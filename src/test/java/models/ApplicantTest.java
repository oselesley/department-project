package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicantTest {

    Applicant applicant;

    @BeforeEach
    void setUp() {
        Department softwareDepartment = new Department(18, "Software Engineering");
        applicant = new Applicant("ujunwa", "odiwa", softwareDepartment, 23);
    }

    @Test
    void testingGetRole() {
        assertEquals(Role.APPLICANT, applicant.getRole());
    }

}