package com.example.demo.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class DefaultStudentService implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student saveStudent(String nameStudent) {
		Student student = new Student();
		student.setName(nameStudent);
		
	
	List<Student> students = findStudents();
		if (students == null) {
		}

		return studentRepository.save(student);
	}

	public List<Student> findStudents() {
		List<Student> students = new ArrayList<>();

		long totalRecords = studentRepository.count();

		if (totalRecords > 0) {
			int recordsByPage = 3;
			if (totalRecords < recordsByPage) {
				Page<Student> pageStudent = studentRepository.findAll(PageRequest.of(0, (int) totalRecords));
				students.addAll(pageStudent.getContent());
				return students;
			}
			
			int totalPages = (int) totalRecords / recordsByPage + 1;
			
			for (int i = 0; i < totalPages; i++) {
				Page<Student> page = studentRepository.findAll(PageRequest.of(i, recordsByPage));
				students.addAll(page.getContent());

			}

			return students;
		}
		return new ArrayList<>();

	}
}
