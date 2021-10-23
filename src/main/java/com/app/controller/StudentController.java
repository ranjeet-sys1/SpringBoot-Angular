package com.app.controller;

import com.app.VO.StudentVO;
import com.app.error.ErrorResponse;
import com.app.model.Student;
import com.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/all")
    public ResponseEntity<Student> getAll(){
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
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id,HttpServletResponse res){
        Map<String,String> response = new HashMap<>();
        if(studentService.isExit(id)){
            studentService.deleteStudent(id);
            return ResponseEntity.ok(id +" is deleted successfully");
        }else{
            ErrorResponse errorResponse =new ErrorResponse();
            errorResponse.setMessage("id doesn't exit");
            errorResponse.setStatus(HttpStatus.NO_CONTENT.name());
            errorResponse.setStatusCode(HttpStatus.NO_CONTENT.value());
            errorResponse.setTimeStamp(new Date());
            return ResponseEntity.ok(errorResponse);
        }
    }
    @GetMapping("/search/name/{name}")
    public ResponseEntity<?> searchStudentByName(@PathVariable("name") String name){
        Student student = studentService.searchStudentByName(name);
        if(student!=null){
            return ResponseEntity.ok().body(student);
        }else{
            ErrorResponse errorResponse =new ErrorResponse();
            errorResponse.setMessage("Student " +name+ " is not exiting with us");
            errorResponse.setStatus(HttpStatus.NO_CONTENT.name());
            errorResponse.setStatusCode(HttpStatus.NO_CONTENT.value());
            errorResponse.setTimeStamp(new Date());
            return ResponseEntity.ok(errorResponse);
        }

    }

    @GetMapping("/search/email/{email}")
    public ResponseEntity<?> searchStudentByEmail(@PathVariable("email") String email){
        Student student = studentService.searchStudentByEmailId(email);
        if(student!=null){
            return ResponseEntity.ok().body(student);
        }else{
            ErrorResponse errorResponse =new ErrorResponse();
            errorResponse.setMessage("Student " +email+ " is not exiting with us");
            errorResponse.setStatus(HttpStatus.NO_CONTENT.name());
            errorResponse.setStatusCode(HttpStatus.NO_CONTENT.value());
            errorResponse.setTimeStamp(new Date());
            return ResponseEntity.ok(errorResponse);
        }

    }

}
