package com.app.controller;

import com.app.VO.StudentVO;
import com.app.model.Student;
import com.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/all")
    public ResponseEntity getAll(){
        List<Student> students = studentService.getAll();
        return  new ResponseEntity(students, HttpStatus.OK);


    }
    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        Map<String,String> response = new HashMap<>();
        if(!student.getStdName().isEmpty() && !student.getStdCourse().isEmpty()
                && !student.getStdEmail().isEmpty() && !student.getPassword().isEmpty()
         ){
            Student savedStudent = studentService.saveStudent(student);
            //response.put("ok",student.getStdName()+" is saved");
            //return ResponseEntity.accepted().body(response);
            return ResponseEntity.ok(student.getStdName()+" is saved");
        }else{
            response.put("error", "an error expected on processing details of student");
            return ResponseEntity.badRequest().body(response);
        }
    }

}
