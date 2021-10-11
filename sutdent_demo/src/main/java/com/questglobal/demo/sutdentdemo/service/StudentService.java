package com.questglobal.demo.sutdentdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.questglobal.demo.sutdentdemo.entity.Address;
import com.questglobal.demo.sutdentdemo.entity.Student;
import com.questglobal.demo.sutdentdemo.repository.StudentRepository;
import com.questglobal.demo.sutdentdemo.response.AddressResponse;
import com.questglobal.demo.sutdentdemo.response.StudentReponse;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	static final String URL_OFFER = "http://localhost:9191/offer/";
	
	public Student registerStudent(Student student){
		return studentRepository.save(student);
	}
	

	public List<Student> registerAllStudent(List<Student>students){
		return studentRepository.saveAll(students);
	}
	 
	
	public List<StudentReponse> getAllStudents(){
		RestTemplate restTemplate = new RestTemplate();
		List<AddressResponse> addressResponses =new ArrayList<>();
		List<Student> studentsList = studentRepository.findAll();
		List<StudentReponse> studentReponses = new ArrayList<>();
		for (Student student : studentsList) {
			StudentReponse studentReponse =  new StudentReponse();
			List<Address> addresses = (List<Address>) student.getAddresses();
			for (Address address : addresses) {
				AddressResponse addressResponse = new AddressResponse();
				addressResponse.setAddId(address.getAddId());
				addressResponse.setCounrty(address.getCounrty());
				addressResponse.setHouse_number(address.getHouse_number());
				addressResponse.setState(address.getState());
				System.out.println(address.getState());
				addressResponse.setOffer(restTemplate.getForObject(URL_OFFER+address.getState(), String.class));
				addressResponses.add(addressResponse);
			}
			
			studentReponse.setAddresses(addressResponses);
			studentReponse.setEmail(student.getEmail());
			studentReponse.setName(student.getName());
			studentReponse.setStudClass(student.getStudClass());
			studentReponse.setStudId(student.getStudId());
			studentReponses.add(studentReponse);
		}
		return studentReponses;
	}
	
	public StudentReponse findStudentById(Integer id){
		Student student = studentRepository.findById(id).orElse(null);
		List<Address>addresses = new ArrayList<>();
		StudentReponse studentReponse = new StudentReponse();
		
		return studentRepository.findById(id).orElse(null);
	}
	
	public List<Student> getAllStudentsByClass(String className){
		System.out.println("Class name is "+className);
		return studentRepository.findByClassName(className);
	}
	
	public String removeStudent(Integer id){
		studentRepository.deleteById(id);
		return "Student removed !!"+id;
		
	}
	
	public Student updateStudent(Student student){
		
		Student existingStudent = studentRepository.findById(student.getStudId()).orElse(null);
		existingStudent.setAddresses(student.getAddresses());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setStudClass(student.getStudClass());
		return studentRepository.save(existingStudent);
	}
}
