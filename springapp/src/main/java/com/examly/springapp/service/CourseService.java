package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Course;
import com.examly.springapp.model.Course;
import com.examly.springapp.model.Course;
import com.examly.springapp.repository.CourseRepo;
@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;
     public Course AddCourse(Course course){
        return courseRepo.save(course);

    }
    public List<Course> getAllCourses(){
        return courseRepo.findAll();
    }
     public Course getCourseById(long CourseId){
        return courseRepo.findById(CourseId).orElseThrow();
    }

    
}
