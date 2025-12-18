package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Instructor;
import com.examly.springapp.repository.InstructorRepo;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepo instructorRepo;

    public Instructor addInstructor(Instructor instructor) {
        return instructorRepo.save(instructor);
    }

    public List<Instructor> getAllInstructors() {
        return instructorRepo.findAll();
    }

    public Instructor getInstructorById(int id) {
        return instructorRepo.findById(id).orElse(null);
    }

    public Instructor updateInstructor(int id, Instructor instructor) {
        instructor.setInstructorId(id);
        return instructorRepo.save(instructor);
    }

    public void deleteInstructor(int id) {
        instructorRepo.deleteById(id);
    }

    public Page<Instructor> getInstructorsWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return instructorRepo.findAll(pageable);
    }

    public List<Instructor> getInstructorBySpecialization(String specialization) {
        return instructorRepo.findBySpecialization(specialization);
    }
}
