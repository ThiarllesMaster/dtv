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
			int totalPages = (int) totalRecords / recordsByPage;

			for (int i = 0; i < totalPages; i++) {
				Page<Student> page = studentRepository.findAll(PageRequest.of(i, recordsByPage));
				students.addAll(page.getContent());

			}
			long resto = totalRecords % totalPages;
			if (resto > 0 || totalPages == 1) {
				int lastPage = totalPages + 1;
				long lastRecords = (resto == 0) ? totalRecords - recordsByPage : resto;
				if (lastRecords > 0) {
					Page<Student> pageStudent = studentRepository.findAll(PageRequest.of((int) lastPage, (int) lastRecords));
					students.addAll(pageStudent.getContent());

				}

			}

			return students;
		}
		return new ArrayList<>();

	}
}
