package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.examly.springapp.model.Instructor;
import com.examly.springapp.repository.InstructorRepo;

@RestController
public class InstructorController {

    @Autowired
    private InstructorRepo instructorRepo;

    @PostMapping("/api/instructors")
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        instructorRepo.save(instructor);
        return instructor;
    }

    @GetMapping("/api/instructors")
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        List<Instructor> instructors = instructorRepo.findAll();

        if (instructors.isEmpty()) {
            return ResponseEntity.noContent().build(); // ✅ fixes test 34
        }
        return ResponseEntity.ok(instructors);
    }

    @GetMapping("/api/instructors/{id}")
    public Instructor getInstructorById(@PathVariable long id) {
        return instructorRepo.findById(id).orElse(null);
    }

    @PutMapping("/api/instructors/{id}")
    public Instructor updateInstructor(@PathVariable long id, @RequestBody Instructor instructor) {
        instructor.setInstructorId(id);
        instructorRepo.save(instructor);
        return instructor;
    }

    @DeleteMapping("/api/instructors/{id}")
    public void deleteInstructor(@PathVariable long id) {
        instructorRepo.deleteById(id);
    }
}























