package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.Instructor;
import com.examly.springapp.service.InstructorService;
@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;
    @PostMapping
    public ResponseEntity<Instructor> add(@RequestBody Instructor instructor) {
        return new ResponseEntity<>(instructorService.addInstructor(instructor), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Instructor> list = instructorService.getAllInstructors();
        if (list.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getById(@PathVariable int id) {
        return new ResponseEntity<>(instructorService.getInstructorById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Instructor> update(@PathVariable int id, @RequestBody Instructor instructor) {
        return new ResponseEntity<>(instructorService.updateInstructor(id, instructor), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        instructorService.deleteInstructor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // Pagination (Day 9)
    @GetMapping("/page/{pageNo}/{pageSize}")
    public ResponseEntity<Page<Instructor>> paginate(@PathVariable int pageNo, @PathVariable int pageSize) {
        return new ResponseEntity<>(
                instructorService.getInstructorsWithPagination(pageNo, pageSize),
                HttpStatus.OK
        );
    }
  
    @GetMapping("/specialization/{specialization}")
    public ResponseEntity<?> bySpecialization(@PathVariable String specialization) {
        List<Instructor> list = instructorService.getInstructorBySpecialization(specialization);
        if (list.isEmpty()) {
            return new ResponseEntity<>(
                    "No instructors found with specialization: " + specialization,
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
