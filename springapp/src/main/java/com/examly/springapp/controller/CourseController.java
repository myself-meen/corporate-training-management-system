package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.examly.springapp.model.Course;
import com.examly.springapp.model.Course;
import com.examly.springapp.model.Course;
import com.examly.springapp.model.Course;
import com.examly.springapp.repository.CourseRepo;
import com.examly.springapp.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

   @PostMapping
    public ResponseEntity<Course> AddCourse(@RequestBody Course course) {
        
        return new ResponseEntity<>(courseService.AddCourse(course), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Course>>getAllCourses(){
        return new ResponseEntity<List<Course>>(courseService.getAllCourses(),HttpStatus.OK);
    }
     @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable long id) {
        return new ResponseEntity<>(courseService.getCourseById(id), HttpStatus.OK);
        
    }
    @PutMapping("/{id}")
    public ResponseEntity<Course>updateCourse(@PathVariable long id, @RequestBody Course course){
        return new ResponseEntity<>(courseService.updateCourse(id, course), HttpStatus.OK);

    }

    // @GetMapping
    // public List<Course> getAllCourses() {
    //     return courseRepo.findAll();
    // }

    // @GetMapping("/{id}")
    // public Course getCourseById(@PathVariable long id) {
    //     return courseRepo.findById(id).orElse(null);
    // }

    // @PutMapping("/{id}")
    // public Course updateCourse(@PathVariable long id, @RequestBody Course course) {
    //     course.setCourseId(id);
    //     courseRepo.save(course);
    //     return course;
    // }
}





