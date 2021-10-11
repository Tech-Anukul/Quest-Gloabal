package com.questglobal.demo.sutdentdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.questglobal.demo.sutdentdemo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query(nativeQuery = true,value = "select * from student where stud_class = upper(?)")
	List<Student> findByClassName(String className);

}
