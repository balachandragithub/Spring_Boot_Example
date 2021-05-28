package com.bala.example.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bala.example.app.model.Student;
import com.bala.example.app.repository.StudentDataRepository;
import com.bala.example.app.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private StudentDataRepository studentDataRepository; 

	@Override
	public Student saveStudent(Student student) {
		 return studentDataRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student,Integer id) {
		Student studentFromDB= studentDataRepository.findStudentById(id);
		if(studentFromDB!= null) {
		studentFromDB.setStdName(student.getStdName());
		studentFromDB.setStdAddress(student.getStdAddress());
		studentFromDB.setStdAge(student.getStdAge());
		}
		return studentDataRepository.save(studentFromDB);
	}

	@Override
	public void deleteStudentById(int id) {
		studentDataRepository.deleteById(id);
		
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> listStudents=new ArrayList<Student>();
		listStudents=studentDataRepository.findAll();
		return listStudents;
	}


}
