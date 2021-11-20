package com.schoolmany.schoolmany.school.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

     @Autowired
     StudentRepository studentRepository;

     @GetMapping
     public List<Student> getStudents() {
         return studentRepository.findAll();
     }

     @PostMapping
     public Student createStudent(@RequestBody Student student) {
         return studentRepository.save(student);
     }

}
