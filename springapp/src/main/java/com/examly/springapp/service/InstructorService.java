package com.examly.springapp.service;
import java.util.List;
import com.examly.springapp.model.Instructor;
import org.springframework.data.domain.Page;

public interface InstructorService {
    Instructor addInstructor(Instructor instructor);
    List<Instructor> getAllInstructors();
    Instructor getInstructorById(int id);
    Instructor updateInstructor(int id, Instructor instructor);
    void deleteInstructor(int id);

    Page<Instructor> getInstructorsWithPagination(int pageNo, int pageSize);
    List<Instructor> getInstructorBySpecialization(String specialization);
}

