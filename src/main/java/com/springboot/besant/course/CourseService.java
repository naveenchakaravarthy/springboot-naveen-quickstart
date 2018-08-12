package com.springboot.besant.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	public List<Course> getAllCourses(){
		return (List<Course>) courseRepository.findAll();
	}

	public void addTopic(Course course) {
		courseRepository.save(course);
	}

	public void deleteTopic(Course course, String id) {
		courseRepository.deleteById(id);
	}
}
