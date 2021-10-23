package com.app.repository;

import com.app.VO.StudentVO;
import com.app.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepo extends JpaRepository<StudentVO,Long> {
    @Query("from StudentVO where stdName=:stdName")
     StudentVO searchStudentByName(String stdName);
    @Query("from StudentVO where stdEmail=:email")
     StudentVO searchStudentByEmailId(String email);
}
