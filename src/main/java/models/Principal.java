/** Principal.java: A class to model the principal of a department and his/her
 * abilities, i.e expel a student, receive new applications, admit an applicant e.t.c
 */

package models;

public class Principal extends Staff {
    private Department department;

    public Principal(String firstName, String lastName, int age, Department department) {
        super("principal", firstName, lastName, department, age);
    }

    /**
     * expelStudent takes in a student and expels the student by calling the department.getStudents()
     * method and removing the student from the map getStudents returns
     * @param student
     * @return Student
     */
    public Student expelStudent (Student student) {
        return getDepartment().getStudents(this).remove(student.getId());
    }

    /**
     * admitStudent takes in a new applicant, then converts that applicant to
     * a student, before adding the student to the list of students in the department
     * @param applicant
     * @return Student
     * @
     */
    public Student admitStudent(Applicant applicant) {
        if (applicant.getAge() < Department.getMinimumAge()) {
            System.out.printf("%s is less than %s and therefore cannot be admitted into %s department",
                    applicant.getFullName(), Department.getMinimumAge(), getDepartment().getName());
            return null;
        }

        // Convert an applicant to a student
        Student student = new Student(applicant.getFirstName(),
                applicant.getLastName(),
                applicant.getDepartment(),
                applicant.getAge());
        getDepartment().getStudents(this).put(student.getId(), student);
        getDepartment().getApplicants(this).remove(applicant.getId());
        return student;
    }

    /**
     * addStaff adds a new staff to the list of staff in the department
     * @param staff
     * @return  Staff
     * @throws NotAllowedException
     */
    public Staff addStaff(Staff staff) {
        getDepartment().getStaff(this).put(staff.getId(), staff);
        return staff;
    }

    /**
     * addApplicant adds an applicant who applied to the department to the
     * list of applicants in the department
     * @param applicant
     * @return Applicant
     * @throws NotAllowedException
     */
    public Applicant addApplicant(Applicant applicant)  {
        department.getApplicants(this).put(applicant.getId(), applicant);
        return applicant;
    }
}
