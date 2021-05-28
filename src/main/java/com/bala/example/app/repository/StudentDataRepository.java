package com.bala.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bala.example.app.model.Student;

@Repository
public interface StudentDataRepository extends JpaRepository<Student, Integer>{
	
	@Query("from Student where stdId = :id")
	public Student findStudentById(@Param("id") Integer id);

}
