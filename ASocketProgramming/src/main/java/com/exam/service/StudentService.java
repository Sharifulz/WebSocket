package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.StudentRepo;
import com.exam.model.Student;

@Service
public class StudentService {

	@Autowired
	StudentRepo repo;
	
	public List<Student> allStudent(){
		return (List<Student>) repo.findAll();
	}
	public void doSave(Student stu) {
		repo.save(stu);
	}
}
