package com.schoolmany.schoolmany.school.subject;

import com.schoolmany.schoolmany.school.student.Student;
import com.schoolmany.schoolmany.school.student.StudentRepository;
import com.schoolmany.schoolmany.school.teacher.Teacher;
import com.schoolmany.schoolmany.school.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject enrollStudentToSubject(Long subjectId, Long studentId) {

        Subject subject = subjectRepository.findById(subjectId).get();
        Student student = studentRepository.findById(studentId).get();
        subject.enrollStudent(student);

        return subjectRepository.save(subject);

    }

    public Subject assignTeacherToSubject(Long subjectId, Long teacherId) {

        Subject subject = subjectRepository.findById(subjectId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();
        subject.assignTeacher(teacher);

        return subjectRepository.save(subject);

    }

}
