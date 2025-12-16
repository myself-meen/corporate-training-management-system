package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.examly.springapp.model.Course;
import com.examly.springapp.repository.CourseRepo;

@RestController
public class CourseController {

    @Autowired
    private CourseRepo courseRepo;

    @PostMapping("/api/courses")
    public Course createCourse(@RequestBody Course course) {
        courseRepo.save(course);
        return course;
    }

    @GetMapping("/api/courses")
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @GetMapping("/api/courses/{id}")
    public Course getCourseById(@PathVariable long id) {
        return courseRepo.findById(id).orElse(null);
    }

    @PutMapping("/api/courses/{id}")
    public Course updateCourse(@PathVariable long id, @RequestBody Course course) {
        course.setCourseId(id);
        courseRepo.save(course);
        return course;
    }
}





