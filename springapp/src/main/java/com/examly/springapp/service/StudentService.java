package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Instructor;
import com.examly.springapp.model.Student;
import com.examly.springapp.model.Student;
import com.examly.springapp.model.Student;
import com.examly.springapp.repository.StudentRepo;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
     public Student AddStudent(Student student){
        return studentRepo.save(student);

    }
     public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }
     public Student getStudentById(long StudentId){
        return studentRepo.findById(StudentId).orElseThrow();
    }

      public Student updateStudent(long StudentId, Student student){
    if(studentRepo.existsById(StudentId)){
       student.setStudentId(StudentId);
       return studentRepo.save(student);
    }
    throw new RuntimeException();


   }


}
