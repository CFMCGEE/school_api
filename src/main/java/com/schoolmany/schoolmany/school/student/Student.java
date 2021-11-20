package com.schoolmany.schoolmany.school.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.schoolmany.schoolmany.school.subject.Subject;

import javax.persistence.*;
import java.util.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //A student is going to have many subjects
    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private Set<Subject> subjects = new HashSet<>();

    private String name;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }


}
