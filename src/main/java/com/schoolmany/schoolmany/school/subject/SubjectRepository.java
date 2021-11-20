package com.schoolmany.schoolmany.school.subject;

import com.schoolmany.schoolmany.school.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
