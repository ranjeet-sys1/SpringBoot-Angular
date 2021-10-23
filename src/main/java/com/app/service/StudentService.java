package com.app.service;

import com.app.VO.StudentVO;
import com.app.model.Student;

import java.util.List;

public interface StudentService {
     List<Student> getAll();
     Student saveStudent(Student student);
     void deleteStudent(Long stdId);
     Boolean isExit(Long stdId);
     Student searchStudentByName(String stdName);
     Student searchStudentByEmailId(String stdName);


}
