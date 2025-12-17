package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.examly.springapp.model.Instructor;
import com.examly.springapp.repository.InstructorRepo;
import com.examly.springapp.service.InstructorService;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<Instructor> AddInstructor(@RequestBody Instructor instructor) {
        
        return new ResponseEntity<>(instructorService.AddInstructor(instructor), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Instructor>>getAllInstructors(){
        return new ResponseEntity<List<Instructor>>(instructorService.getAllInstructors(),HttpStatus.OK);
    }

    // @GetMapping
    // public ResponseEntity<List<Instructor>> getAllInstructors() {
    //     List<Instructor> instructors = instructorRepo.findAll();

    //     if (instructors.isEmpty()) {
    //         return ResponseEntity.noContent().build(); 
    //     }
    //     return ResponseEntity.ok(instructors);
    // }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable long id) {
        return new ResponseEntity<>(instructorService.getInstructorById(id), HttpStatus.OK);
        
    }



    @PutMapping("/{id}")
    public ResponseEntity<Instructor>updateInstructor(@PathVariable long id, @RequestBody Instructor instructor){
        return new ResponseEntity<>(instructorService.updateInstructor(id, instructor), HttpStatus.OK);

    }
    // public Instructor updateInstructor(@PathVariable long id, @RequestBody Instructor instructor) {
    //     instructor.setInstructorId(id);
    //     instructorRepo.save(instructor);
    //     return instructor;
    // }

    // @DeleteMapping("/{id}")
    // public void deleteInstructor(@PathVariable long id) {
    //     instructorRepo.deleteById(id);
    // }
}























