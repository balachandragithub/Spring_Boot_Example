package com.bala.example.app.service;

import java.util.List;

import com.bala.example.app.model.Student;

public interface IStudentService {
	
	
	public Student saveStudent(Student student);
	public Student updateStudent(Student student,Integer id);
	public void deleteStudentById(int id);
	public List<Student> getAllStudents();

}
