package com.schoolmany.schoolmany.school.teacher;

import com.schoolmany.schoolmany.school.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
