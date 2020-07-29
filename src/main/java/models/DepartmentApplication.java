package models;


import java.time.LocalTime;

public class DepartmentApplication {
    public static void main(String[] args) throws NotAllowedException {
        Department softwareDepartment = new Department(18, "Software Engineering");

        Principal principal = new Principal("Chibueze",
                "Eziokwubundu", 28, softwareDepartment);

        softwareDepartment.setPrincipal(principal);
        System.out.println(principal + "\n");

        // Create a new applicant
        Applicant applicant = new Applicant("ujunwa", "odiwa", softwareDepartment, 23);
        Applicant applicant2 = new Applicant("fred", "chinazor", softwareDepartment, 25);
        Applicant applicant3 = new Applicant("kenechukwu", "michael", softwareDepartment, 26);
        Applicant applicant4 = new Applicant("james", "danladi", softwareDepartment, 22);
        Applicant applicant5 = new Applicant("adesola", "adekan", softwareDepartment, 17);


        // Add Applicants to department
        softwareDepartment.getApplicants(principal).put(applicant.getId(), applicant);
        softwareDepartment.getApplicants(principal).put(applicant2.getId(), applicant2);
        softwareDepartment.getApplicants(principal).put(applicant3.getId(), applicant3);
        softwareDepartment.getApplicants(principal).put(applicant4.getId(), applicant4);

        // Create Teachers
        Teacher teacher = new Teacher("David", "Odohi", softwareDepartment, 28);
        Teacher teacher1 = new Teacher("Gadibia", "Oghenetevwodaro", softwareDepartment, 27);


        // Create new Departmental courses
        Course SFE101 = new Course("Fundamentals of Software Engineering",
                "SFE 101: An intoduction to the fundamentals of Software development. At the" +
                        "end of this course, students should be conversant with core software engineering concepts",
                101L, teacher);

        Course DET117 = new Course("Introduction to Design Thinking",
                "DET 117: Introduces students to the processes behind enterprise grade software" +
                        "design. at the end of this course, students should be confident in their ability to design " +
                        "small scale yet low latent and fault tolerant systems",
                117L, teacher1);

        Course OOP107 = new Course("Object Oriented Programming Concepts",
                "OOP 107: Object Oriented Programming is an important programming paradigm in " +
                        "modern software development. This course dives deep into the obscure parts of OOP. At the end of " +
                        "this course, students should be able to model robust systems using OOP and SOLID principles",
                107L, teacher1);

        Course DSA211 = new Course("Algorithms and Data Structures",
                "DSA211: Algorithms and Data Structures introduces students to problem solving in" +
                        "computer science. Common sorting, searching and hashing algorithms are covered. Students are " +
                        "introduced to algorithmic performance benchmarking using the Big O notation. At the end of " +
                        "this course, students should have advanced problem solving skills and know the tradeoffs between " +
                        "popular algorithms and data structures",
                211L, teacher);

        Course MEG201 = new Course("Thermodynamics",
                "MEG201: Thermodynamics introduces students to concepts such as open and closed systems" +
                        "Laws of thermodynamics, corollaries of the laws of thermodynamics and so on",
                201L, teacher1);

        softwareDepartment.getStaff(principal).put(teacher.getId(), teacher);
        softwareDepartment.getStaff(principal).put(teacher1.getId(), teacher1);
        softwareDepartment.getCourses(principal).put(SFE101.getCourseCode(), SFE101);
        softwareDepartment.getCourses(principal).put(OOP107.getCourseCode(), OOP107);
        softwareDepartment.getCourses(principal).put(DET117.getCourseCode(), DET117);
        softwareDepartment.getCourses(principal).put(DSA211.getCourseCode(), DSA211);
        Course addedSFE101 = teacher.addCourse(SFE101);
        Course addedDSA211 = teacher.addCourse(DSA211);
        Course addedDET1172 = teacher1.addCourse(DET117);
        Course addedOOP107 = teacher1.addCourse(OOP107);
        Course addedDET117 = teacher.addCourse(DET117);
        System.out.println(addedSFE101);

        // Try to add a course not in departmental courses
        Course addedMMEG201 = teacher1.addCourse(MEG201);

        // Principal admits students
        Student student = principal.admitStudent(applicant);
        Student student1 = principal.admitStudent(applicant2);
        Student student3 = principal.admitStudent(applicant4);
        Student student4 = principal.admitStudent(applicant5);

        System.out.printf("%n%s has been admitted to %s department%n", student.getFullName(), softwareDepartment.getName());
        System.out.printf("%s has been admitted to %s department%n%n", student1.getFullName(), softwareDepartment.getName());


        System.out.println(softwareDepartment);

        // Principal expels students
        Student expelledStudent = principal.expelStudent(student3);
        System.out.printf("%n%s has been expelled from the %s department%n", expelledStudent.getFullName(), softwareDepartment.getName());
        System.out.println(softwareDepartment);

        // Student takes a course
        student.takeCourse(DET117);
        student.takeCourse(DSA211);
        System.out.printf("%n%s is currently taking the following courses %s%n",
                student.getFullName(), student.getCurrCourses().values());

        // A teacher takes a course
        teacher.takeClass(DET117, 2, LocalTime.of(2, 30));
        System.out.println(DET117.getClasses());
    }
}
