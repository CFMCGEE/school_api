package com.schoolmany.schoolmany.school.subject;

import com.schoolmany.schoolmany.school.student.Student;
import com.schoolmany.schoolmany.school.teacher.Teacher;

import javax.persistence.*;
import java.util.*;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Subject is going to have many students
    @ManyToMany
    @JoinTable(
            name = "STUDENTS_ENROLLED",
            joinColumns = @JoinColumn(name = "SUBJECT_ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID")
    )
    private Set<Student> enrolledStudents = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TEACHER_ID", referencedColumnName = "id")
    private Teacher teacher;

    private String name;

    public Teacher getTeacher() {
        return teacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
