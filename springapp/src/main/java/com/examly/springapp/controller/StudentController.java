package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.examly.springapp.model.Student;
import com.examly.springapp.repository.StudentRepo;

@RestController
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @PostMapping("/api/students")
    public Student createStudent(@RequestBody Student student) {
        studentRepo.save(student);
        return student;
    }

    @GetMapping("/api/students")
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @GetMapping("/api/students/{id}")
    public Student getStudentById(@PathVariable long id) {
        return studentRepo.findById(id).orElse(null);
    }

    @PutMapping("/api/students/{id}")
    public Student updateStudent(@PathVariable long id, @RequestBody Student student) {
        student.setStudentId(id);
        studentRepo.save(student);
        return student;
    }
}





