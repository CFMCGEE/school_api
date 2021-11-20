package com.schoolmany.schoolmany.school.subject;

import com.schoolmany.schoolmany.school.student.Student;
import com.schoolmany.schoolmany.school.student.StudentRepository;
import com.schoolmany.schoolmany.school.student.StudentService;
import com.schoolmany.schoolmany.school.teacher.Teacher;
import com.schoolmany.schoolmany.school.teacher.TeacherRepository;
import com.schoolmany.schoolmany.school.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

     @Autowired
     SubjectService subjectService;

     @GetMapping
     List<Subject> getSubjects() {
         return subjectService.getSubjects();
     }

     @PostMapping
     public Subject createSubject(@RequestBody Subject subject) {
         return subjectService.createSubject(subject);
     }

     @PutMapping("/{subjectId}/students/{studentId}")
     public Subject enrollStudentToSubject(@PathVariable Long subjectId, @PathVariable Long studentId) {
         return subjectService.enrollStudentToSubject(subjectId, studentId);
     }

    @PutMapping("/{subjectId}/teacher/{teacherId}")
    public Subject assignTeacherToSubject(@PathVariable Long subjectId, @PathVariable Long teacherId) {
         return subjectService.assignTeacherToSubject(subjectId, teacherId);
    }

}
