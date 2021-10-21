package com.app.service;

import com.app.VO.StudentVO;
import com.app.model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAll();
    public Student saveStudent(Student student);


}
