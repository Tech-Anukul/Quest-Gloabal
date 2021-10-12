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
	
	@Autowired
	RestTemplate restTemplate ;
	public Student registerStudent(Student student){
		return studentRepository.save(student);
	}
	

	public List<Student> registerAllStudent(List<Student>students){
		return studentRepository.saveAll(students);
	}
	 
	public List<StudentReponse> getAllStudents(){
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
				String offer = restTemplate.getForObject(URL_OFFER+address.getState(), String.class);
				addressResponse.setOffer(offer == null || offer.equals("")? "No Offer Available": offer);
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
		List<AddressResponse> addressResponses =new ArrayList<>();
		List<Address>addresses = new ArrayList<>();
		StudentReponse studentReponse = new StudentReponse();
		studentReponse.setEmail(student.getEmail());
		studentReponse.setName(student.getName());
		studentReponse.setStudClass(student.getStudClass());
		studentReponse.setStudId(student.getStudId());
		addresses = (List<Address>) student.getAddresses();
		for (Address address : addresses) {
			AddressResponse addressResponse = new AddressResponse();
			addressResponse.setAddId(address.getAddId());
			addressResponse.setCounrty(address.getCounrty());
			addressResponse.setHouse_number(address.getHouse_number());
			addressResponse.setState(address.getState());
			String offer = restTemplate.getForObject(URL_OFFER+address.getState(), String.class);
			addressResponse.setOffer(offer == null || offer.equals("")? "No Offer Available": offer);
			addressResponses.add(addressResponse);
		}
		studentReponse.setAddresses(addressResponses);
		return studentReponse;
	}
	
	public List<StudentReponse> getAllStudentsByClass(String className){
		List<AddressResponse> addressResponses =new ArrayList<>();
		List<Student> studentsList = studentRepository.findByClassName(className);
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
				String offer = restTemplate.getForObject(URL_OFFER+address.getState(), String.class);
				addressResponse.setOffer(offer == null || offer.equals("")? "No Offer Available": offer);
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
