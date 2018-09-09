package com.springboot.repository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.springboot.model.Student;

@Service
public class StudentService implements StudentRepository {

	private static final String TABLE_NAME = "Student";

	private RedisTemplate<String, Object> redisTemplate;

	private HashOperations<String, Long, Student> hashOperations;

	@Autowired
	public StudentService(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@PostConstruct
	private void intializeHashOperations() {
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		hashOperations.put(TABLE_NAME, student.getId(), student);
	}

	@Override
	public Student find(Long id) {
		// TODO Auto-generated method stub
		return hashOperations.get(TABLE_NAME, id);
	}
}