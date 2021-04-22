package com.springrest.springrest.services;

import java.util.*;

import com.springrest.springrest.entities.Course;

public interface CourseService 
{
	public List<Course> getCourses();

	public Course getCourse(long CourseId);

	public Course addCourse(Course course);

	public Course updateCorses(Course course);

	public void deleteCourse(long parseLong);
}
