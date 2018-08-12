package com.springboot.besant.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4300", maxAge=3600)
@RestController
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping("/")
	public String indexMethod() {
		return "Hello World!";
	}
	
	@RequestMapping("/courses")
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/courses")
	public String addCourse(@RequestBody Course course) {
		courseService.addTopic(course);
		String response = "{\"success\": true, \"message\": Topic has been added successfully.}";
		return response;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/course/{id}")
	public String deleteCourse(@RequestBody Course course, @PathVariable String id) {
		courseService.deleteTopic(course, id);
		String response = "{\"success\": true, \"message\": Topic has been deleted.}";
		return response;
	}
}
