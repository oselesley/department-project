package models;

import java.util.*;

public class Course {
    private String courseName;
    private String courseDescription;
    private Long courseCode;
    private Map<Long, Student> students = new HashMap<>();
    private Teacher teacher;
    private Set<Course> prerequisites = new HashSet<>();
    private List<Class> classes = new ArrayList<>();

    public Course(String courseName, String courseDescription, Long courseCode, Teacher teacher) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseCode = courseCode;
        this.teacher = teacher;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public Long getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(Long courseCode) {
        this.courseCode = courseCode;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * addStudent adds a student to the course if
     * @param student
     * @param person
     * @return student
     * @throws NotAllowedException
     */
    public Student addStudent(Student student, Person person) {
        if ((person.getRole() != Role.TEACHER && !this.teacher.equals(person)) &&
                person.getRole() != Role.PRINCIPAL) {
            System.out.println("You do not have the required permissions to add a student to this course!");
            return null;
        }
        students.put(student.getId(), student);
        return student;
    }

    public Student removeStudent(Long id) {
        return students.remove(id);
    }

    public Student getStudent(Long id) {
        return students.get(id);
    }

    public Set<Student> getAllStudents() {
        Set<Student> studentSet = new HashSet<Student>();
        studentSet.addAll(students.values());
        return studentSet;
    }

    public Map<Long, Student> getStudents() {
        return students;
    }

    public void setStudents(Map<Long, Student> students) {
        this.students = students;
    }


    public Set<Course> getPrerequisite() {
        return prerequisites;
    }

    /**
     * aadClass adds a new clas to the list of classes undertaken through out the semester
     *
     * @param newClass
     * @return Class
     */
    public Class addClass(Class newClass) {
        classes.add(newClass);
        return newClass;
    }

    /**
     * getClasses gets all classes taken for this course
     * @return List<Class>
     */
    public List<Class> getClasses() {
        return classes;
    }

    @Override
    public String toString() {
        return String.format("course: %s, teacher: %s%n",
                getCourseName(),
                this.getTeacher().getFullName()
        );
    }
}
