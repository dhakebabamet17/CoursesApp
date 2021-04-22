package com.springrest.springrest.controller;

import java.util.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class Controller1 
{
	@Autowired
	private CourseService Course_Service;
	
	@GetMapping("/home")
	public String home()
	{
		return "Welcome to Courses application";
	}
	
	//get the courses
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return this.Course_Service.getCourses();
	}
	
	@GetMapping("/courses/{CourseId}")
	public Course getCourse(@PathVariable String CourseId)
	{
		return this.Course_Service.getCourse(Long.parseLong(CourseId));
	}
	
	@PostMapping("/courses")
	public Course addCourses(@RequestBody Course course)
	{
		return this.Course_Service.addCourse(course);
	}
	
	@PutMapping("/courses")
	public Course updateCorses(@RequestBody Course course)
	{
		return this.Course_Service.updateCorses(course);
	}
	
	@DeleteMapping("/courses/{CourseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String CourseId)
	{
		try
		{
			this.Course_Service.deleteCourse(Long.parseLong(CourseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	
	
}
