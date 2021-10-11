package com.questglobal.demo.sutdentdemo.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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
	private static final Logger LOGGER = LogManager.getLogger(StudentController.class);
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
		 /*HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<String> entity = new HttpEntity<String>(headers);
		System.out.println(restTemplate.exchange("http://localhost:9191/offer/"+"MP",HttpMethod.GET, entity, String.class).getBody());*/
		List<StudentReponse> studentReponses = studentService.getAllStudents();
		return ResponseEntity.ok(studentReponses);
	}

	@GetMapping("findStudentById/{id}")
	public Student findStudentById(@PathVariable Integer id) {
		System.out.println(studentService.findStudentById(id));
		return studentService.findStudentById(id);
	}

	@GetMapping("/getAllStudentsByClass/{className}")
	public List<Student> getAllStudentsByClass(@PathVariable String className) {
		try {
			return studentService.getAllStudentsByClass(className);
		} catch (Exception e) {
			LOGGER.error("Error level log message"+e);
		}
	return null;
	}
	
	@PostMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("/removeStudent")
	public String removeStudent(@RequestBody Integer id) {
		return studentService.removeStudent(id);
	}
}
