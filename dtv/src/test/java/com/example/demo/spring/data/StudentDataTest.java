package com.example.demo.spring.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentDataTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void test() {
		Student student = new Student();
		student.setName("Rafinha");
		
		entityManager.persist(student);
		
		Student studentReturned = studentRepository.findById(1L).get();
		student.setStudentId(1L);
		assertThat(studentReturned, equalTo(student));
	}
	
	@Test 
	public void countBy() {
		
	}

}
