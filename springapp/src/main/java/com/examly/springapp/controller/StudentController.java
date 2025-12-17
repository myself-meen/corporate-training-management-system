package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.examly.springapp.model.Student;
import com.examly.springapp.model.Student;
import com.examly.springapp.model.Student;
import com.examly.springapp.repository.StudentRepo;
import com.examly.springapp.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    
    private StudentService studentService;
      @PostMapping
    public ResponseEntity<Student> AddStudent(@RequestBody Student student) {
        
        return new ResponseEntity<>(studentService.AddStudent(student), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Student>>getAllStudents(){
        return new ResponseEntity<List<Student>>(studentService.getAllStudents(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
        
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student>updateStudent(@PathVariable long id, @RequestBody Student student){
        return new ResponseEntity<>(studentService.updateStudent(id, student), HttpStatus.OK);

    }




    // @PostMapping
    // public Student createStudent(@RequestBody Student student) {
    //     studentRepo.save(student);
    //     return student;
    // }

    // @GetMapping
    // public List<Student> getAllStudents() {
    //     return studentRepo.findAll();
    // }

    // @GetMapping("/{id}")
    // public Student getStudentById(@PathVariable long id) {
    //     return studentRepo.findById(id).orElse(null);
    // }

    // @PutMapping("/{id}")
    // public Student updateStudent(@PathVariable long id, @RequestBody Student student) {
    //     student.setStudentId(id);
    //     studentRepo.save(student);
    //     return student;
    // }
}





