package models;


import java.time.LocalTime;
import java.util.*;

public class Teacher extends Staff {

    private Map<Long, Course> courses = new HashMap<>();
    private Stack<Class> classes = new Stack<>();
    private UUID uniqueCode;

    public Teacher(String firstName, String lastName, Department department, int age) {
        super("Teacher", firstName, lastName, department, age);
        UUID uniqueCode = UUID.randomUUID();
    }

    /**
     * Return a Set of courses the Teacher is required to take
     * they should be unique and unmodifiable, hence the set.
     * @return
     */
    public Set<Course> getCourses() {
        Set<Course> courseSet = new HashSet<>();
        courseSet.addAll(courses.values());
        return courseSet;
    }

    private UUID getUniqueCode() {
        return uniqueCode;
    }

    /**
     * Add  course to the list of courses the teacher is required to take
     * @return course
     */
    public Course addCourse(Course course)  {
        if (!getDepartment().getCourses().contains(course)) {
            System.out.println("This course doesn't exist!");
            return null;
        }
        if (!course.getTeacher().equals(this)) {
            System.out.println("You are not allowed to take this course!");
            return null;
        }
        courses.put(course.getCourseCode(), course);
        return course;
    }

    /**
     * addStudentToCourse adds a student to the course if there is no pre-requisite to the course
     * and if the student belongs to the department
     * @param student
     * @return Course
     */
    public Course addStudentToCourse(Student student, Course course)  {
        if (course.getPrerequisite().size() == 0
                && getDepartment().getStudents().contains(student)) {
            course.addStudent(student, this);
            return course;
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;

        Teacher thr = (Teacher) obj;
        return this.getId().equals(thr.getId()) && this.getAge() == ((Teacher) obj).getAge()
                && this.getFullName().equals(((Teacher) obj).getFullName());
    }

    /**
     * When a Teacher takes a course, (class in this context) it is added to
     * the list of classes taken for the course throughout the semester. The course taken, the duration of the class
     * and the start time of the class is given. This method should only be called by the
     * teacher object. A student shouldn't create a class.
     * @param course
     * @param duration
     * @param time
     */
    public void takeClass(Course course, int duration, LocalTime time) {
        course.addClass(new Class(course, this, duration, time));
        System.out.println(this.getFullName() + " is currently teaching " + course.getCourseName());
    }

    /**
     * Add a student to the attendance register for the class;
     * @param student
     * @param classPeriod
     */
    public void addStudentToClass(Student student, Class classPeriod) {
        classPeriod.addStudentToAttendanceRegister(student);
    }

    /**
     * addStudentsToClass adds a list of students to the attendance register for the class
     * @param students
     * @param classPeriod
     */
    public void addStudentsToClass(Collection<Student> students, Class classPeriod) {
        students.forEach(classPeriod::addStudentToAttendanceRegister);
    }

}
