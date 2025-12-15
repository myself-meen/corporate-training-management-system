package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {
@Id
private long courseId;
private String courseName;
private String description;
private int duration;
private double price;
public long getCourseId() {
    return courseId;
}
public void setCourseId(long courseId) {
    this.courseId = courseId;
}
public String getCourseName() {
    return courseName;
}
public void setCourseName(String courseName) {
    this.courseName = courseName;
}
public String getDescription() {
    return description;
}
public void setDescription(String description) {
    this.description = description;
}
public int getDuration() {
    return duration;
}
public void setDuration(int duration) {
    this.duration = duration;
}
public double getPrice() {
    return price;
}
public void setPrice(double price) {
    this.price = price;
}
public Course() {
}


}
