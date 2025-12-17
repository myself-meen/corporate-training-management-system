package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Instructor;
import com.examly.springapp.repository.InstructorRepo;

@Service

public class InstructorService {
    @Autowired
    private InstructorRepo instructorRepo;
    
    public Instructor AddInstructor(Instructor instructor){
        return instructorRepo.save(instructor);

    }
    public List<Instructor> getAllInstructors(){
        return instructorRepo.findAll();
    }
    public Instructor getInstructorById(long instructorId){
        return instructorRepo.findById(instructorId).orElseThrow();
    }
    
   public Instructor updateInstructor(long instructorId, Instructor instructor){
    if(instructorRepo.existsById(instructorId)){
       instructor.setInstructorId(instructorId);
       return instructorRepo.save(instructor);
    }
    throw new RuntimeException();


   }
    


    
}
