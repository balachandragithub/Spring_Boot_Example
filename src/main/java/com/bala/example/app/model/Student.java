package com.bala.example.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Student {
	
	
	@Id
	@GeneratedValue
	private Integer stdId;
	private String stdName;
	private String stdAddress;
	private int stdAge;

}
