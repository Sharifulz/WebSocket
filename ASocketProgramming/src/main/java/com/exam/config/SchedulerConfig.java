package com.exam.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.exam.model.Student;
import com.exam.service.StudentService;

@EnableScheduling
@Configuration
public class SchedulerConfig {

	
//	  @Autowired SimpMessagingTemplate template;
//	  
//	  @Autowired StudentService service;
//	  
//	  @Scheduled(fixedDelay = 3000) 
//	  public void sendAdhocMessages() { 
//		  List<Student> studentList = new ArrayList<Student>(); 
//		  studentList = service.allStudent();
//	  template.convertAndSend("/topic/user", studentList);
//}
	 
}
