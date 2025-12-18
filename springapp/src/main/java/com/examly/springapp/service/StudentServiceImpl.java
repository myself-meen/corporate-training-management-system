package com.examly.springapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Student;
import com.examly.springapp.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepo.findById(id).orElse(null);
    }

    public Student updateStudent(int id, Student student) {
        student.setStudentId(id);
        return studentRepo.save(student);
    }

    public Student getStudentByEmail(String email) {
        return studentRepo.findByEmail(email);
    }
}
