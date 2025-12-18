package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Course;
import com.examly.springapp.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> add(@RequestBody Course c) {
        return new ResponseEntity<>(courseService.addCourse(c), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAll() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getById(@PathVariable int id) {
        return new ResponseEntity<>(courseService.getCourseById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable int id, @RequestBody Course c) {
        return new ResponseEntity<>(courseService.updateCourse(id, c), HttpStatus.OK);
    }

    @GetMapping("/instructor/{id}")
    public ResponseEntity<List<Course>> byInstructor(@PathVariable int id) {
        return new ResponseEntity<>(courseService.getCoursesByInstructor(id), HttpStatus.OK);
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<?> byLevel(@PathVariable String level) {
        List<Course> list = courseService.getCoursesByLevel(level);
        if (list.isEmpty()) {
            return new ResponseEntity<>("No courses found at level: " + level, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
