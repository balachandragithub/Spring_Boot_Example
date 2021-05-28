package com.bala.example.app.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bala.example.app.model.Student;
import com.bala.example.app.service.IStudentService;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	@Autowired
	private IStudentService iStudentService;

	@PostMapping("/saveStudent")
	public ResponseEntity<Student> saveStudentDetails(@RequestBody Student student){
		Student studentDetails=iStudentService.saveStudent(student);
		ResponseEntity<Student> responseEntity=new ResponseEntity<Student>(studentDetails, HttpStatus.OK);
		return responseEntity;

	}

	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<Student> updateStudentDetails(@RequestBody Student student,@PathVariable Integer id){
		Student studentUpdatedDetails=iStudentService.updateStudent(student,id);
		ResponseEntity<Student> responseEntity=new ResponseEntity<Student>(studentUpdatedDetails, HttpStatus.OK);
		return responseEntity;

	}

	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> listStudents=new ArrayList<Student>();
		listStudents=iStudentService.getAllStudents();
		return new ResponseEntity<List<Student>>(listStudents,HttpStatus.OK);

	}
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable Integer id){
		iStudentService.deleteStudentById(id);
		return new ResponseEntity<String>("Student deleted with id '"+ id +"' successfully",HttpStatus.OK);
	}


}
