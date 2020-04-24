package com.example.demo.spring.service;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.student.DefaultStudentService;
import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import com.example.demo.student.StudentService;

@RunWith(SpringRunner.class)
public class StudentServiceTest {
	
	private StudentService studentService;
	
	@Mock
	private StudentRepository studentRepository;

	@Test
	public void testSaveStudent() {
		
		Student student = new Student();
		student.setName("Rafinha");

		when(studentRepository.save(student)).thenReturn(student);
		
		studentService = new DefaultStudentService(studentRepository);
		Student studentReturned = studentService.saveStudent(student.getName());
		
		assertThat(studentReturned, equalTo(student));		
		
	}

}
