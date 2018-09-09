package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Student;
import com.springboot.repository.StudentService;

@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private StudentService studentService;

	@PostMapping
	public void saveStudentInformation(@RequestBody Student student) {
		studentService.save(student);
	}

	@Cacheable(key="#id", value="students", unless = "#result.id < 1200")
	@GetMapping(path = "{id}")
	public Student fetchStudent(@PathVariable("id") long id) {
		return studentService.find(id);
	}
	
	//@CacheEvict - Delete from Cache. Use it with DeleteMapping
	//@CachePut - Update a Cache. Use it with PutMapping
}