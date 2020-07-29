package models;


import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Class {
    private Course course;
    private Teacher teacher;
    private final Set<Student> studentsInAttendance = new HashSet<>();
    private int duration;
    private LocalTime startTime;

    public Class(Course course, Teacher teacher, int duration, LocalTime startTime) {
        this.course = course;
        this.teacher = teacher;
        this.duration = duration;
        this.startTime = startTime;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<Student> getStudentsInAttendance() {
        return studentsInAttendance;
    }

    public void addStudentToAttendanceRegister(Student student) {
        this.studentsInAttendance.add(student);
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Class{" +
                "course=" + course.getCourseName() +
                ", teacher=" + teacher.getFullName() +
                ", studentsInAttendance=" + studentsInAttendance +
                ", duration=" + duration +
                "hrs, startTime=" + startTime +
                '}';
    }
}

