package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Course;
import com.examly.springapp.repository.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    public Course addCourse(Course course) { return courseRepo.save(course); }
    public List<Course> getAllCourses() { return courseRepo.findAll(); }
    public Course getCourseById(int id) { return courseRepo.findById(id).orElse(null); }

    public Course updateCourse(int id, Course course) {
        course.setCourseId(id);
        return courseRepo.save(course);
    }

    public List<Course> getCoursesByInstructor(int instructorId) {
        return courseRepo.findByInstructor_InstructorId(instructorId);
    }

    public List<Course> getCoursesByLevel(String level) {
        return courseRepo.findByLevel(level);
    }
   
}
