package com.exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Student;
import com.exam.service.StudentService;

@RestController
@EnableScheduling
@Configuration
@RequestMapping("/stu")
public class StudentRestController {

	@Autowired
	StudentService service;
	 @Autowired
	 SimpMessagingTemplate template;
	 

	  @Scheduled(fixedDelay = 3000) 
	  public void sendAdhocMessages() { 
		  List<Student> studentList = new ArrayList<Student>(); 
		  studentList = service.allStudent();
	  template.convertAndSend("/topic/user", studentList);
	  	}
	 

	 
	@RequestMapping("/allStu")
	public List<Student> allStudent(){
		return service.allStudent();
	}
	
	@RequestMapping("/save")
	public void saveStudent(@RequestBody Student stu) {
		service.doSave(stu);
	}
}
