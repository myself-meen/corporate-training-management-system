package com.examly.springapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Enrollment {
 @Id
private long enrollmentId;
@ManyToOne(targetEntity = Course.class, cascade = CascadeType.ALL)
private long courseId;
@ManyToOne(targetEntity = Student.class, cascade = CascadeType.ALL)
private long studentId;
public long getEnrollment() {
    return enrollmentId;
}
public void setEnrollment(long enrollment) {
    this.enrollmentId = enrollment;
}
public long getCourseId() {
    return courseId;
}
public void setCourseId(long courseId) {
    this.courseId = courseId;
}
public long getStudentId() {
    return studentId;
}
public void setStudentId(long studentId) {
    this.studentId = studentId;
}
public Enrollment() {
}

}
