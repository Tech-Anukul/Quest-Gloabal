package com.questglobal.demo.sutdentdemo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.questglobal.demo.sutdentdemo.entity.Student;
import com.questglobal.demo.sutdentdemo.response.StudentReponse;
import com.questglobal.demo.sutdentdemo.service.StudentService;

@RestController
public class StudentController {

	
	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Autowired
	StudentService studentService;
	@PostMapping("/registerStudent")
	public Student addStudent(@RequestBody Student student) {
		return studentService.registerStudent(student);
	}

	@PostMapping("/registerAllStudent")
	public List<Student> saveStudents(@RequestBody List<Student> students) {
		return studentService.registerAllStudent(students);
	}

	@GetMapping("/getAllStudents")
	public ResponseEntity<List<StudentReponse>> getAllStudents() {
		List<StudentReponse> studentReponses = studentService.getAllStudents();
		return ResponseEntity.ok(studentReponses);
	}

	@GetMapping("findStudentById/{id}")
	public ResponseEntity<StudentReponse> findStudentById(@PathVariable Integer id) {
		StudentReponse studentReponse = studentService.findStudentById(id);
		return ResponseEntity.ok(studentReponse);
	}

	@GetMapping("/getAllStudentsByClass/{className}")
	public ResponseEntity<List<StudentReponse>> getAllStudentsByClass(@PathVariable String className) {
		List<StudentReponse> studentReponses = studentService.getAllStudentsByClass(className);
		return ResponseEntity.ok(studentReponses);
	}
	
	@PostMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("/removeStudent/{id}")
	public String removeStudent(@PathVariable Integer id) {
		return studentService.removeStudent(id);
	}
}
