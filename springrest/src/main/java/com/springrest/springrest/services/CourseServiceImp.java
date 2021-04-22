package com.springrest.springrest.services;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.dao.CourseDao;


@Service
public class CourseServiceImp implements CourseService
{
	@SuppressWarnings("unused")
	@Autowired
	private CourseDao CourseDao;
	
	//List<Course> list;
	
	public CourseServiceImp() 
	{
		/*
		list = new ArrayList<>();
		list.add(new Course(32, "Fundamentals of Java", 
			"This course takes us through the fundamentals of Java."));
		list.add(new Course(36, "Data Structures and Algorithms with Java", 
			"This course takes us through the fundamentals of Data structures and Algorithms in Java."));
		*/
	}
	
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return CourseDao.findAll();
	}

	@Override
	public Course getCourse(long CourseId) 
	{
		/*
		Course course = null;
		for(Course c : list)
		{
			if(c.getId()==CourseId)
			{
				course = c;
				break;
			}
		}
		*/
		return CourseDao.getOne(CourseId);
	}

	public Course addCourse(Course course)
	{
		//list.add(course);
		
		CourseDao.save(course);
		return course;
	}

	@Override
	public Course updateCorses(Course course) 
	{
		
		/*
		Course temp = null;
		for(Course c : list)
		{
			if(c.getId()==course.getId())
			{
				list.remove(c);
				list.add(course);
				temp = course;
			}
		}
		*/
		CourseDao.save(course);
		return course;
	}
	
	public void deleteCourse(long CourseId)
	{
		//list = this.list.stream().filter(e -> e.getId()!=CourseId).collect(Collectors.toList());
		Course entity = CourseDao.getOne(CourseId);
		CourseDao.delete(entity);
	}
	
}
