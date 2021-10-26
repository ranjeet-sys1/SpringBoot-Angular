package com.app.service;

import com.app.VO.StudentVO;
import com.app.model.Student;
import com.app.repository.StudentRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public List<Student> getAll(){
        List<StudentVO> studentVO = studentRepo.findAll();
        List<Student> students = new ArrayList<>();
        for(StudentVO st:studentVO){
            Student student = new Student();
            student.setStdId(st.getStdId());
            student.setStdName(st.getStdName());
            student.setStdCourse(st.getStdCourse());
            student.setStdFee(st.getStdFee());
            student.setStdEmail(st.getStdEmail());
            students.add(student);
        }
        return  students;


    }

    @Override
    public Student saveStudent(Student student) {
        StudentVO studentVO = new StudentVO();
        BeanUtils.copyProperties(student,studentVO);
        studentRepo.save(studentVO);
        return student;
    }

    @Override
    public void deleteStudent(Long stdId) {
        studentRepo.deleteById(stdId);
    }

    @Override
    public Boolean isExit(Long stdId) {
        return studentRepo.existsById(stdId);

    }

    @Override
    public Student searchStudentByName(String stdName) {
        StudentVO studentVO = studentRepo.searchStudentByName(stdName);
        Student student = new Student();
        BeanUtils.copyProperties(studentVO,student);
        return student;
    }

    @Override
    public Student searchStudentByEmailId(String email) {
        StudentVO studentVO = studentRepo.searchStudentByEmailId(email);
        Student student = new Student();
        BeanUtils.copyProperties(studentVO,student);
        return student;
    }

    @Override
    public Student getStudent(Long id) {
        StudentVO studentVO = studentRepo.getById(id);
        Student student = new Student();
        BeanUtils.copyProperties(studentVO,student);
        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        StudentVO studentVO =new StudentVO();
        BeanUtils.copyProperties(student,studentVO);
        studentRepo.save(studentVO);
        return student;
    }

}
