package com.pradeip.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_student")
public class Student {

	@Id
	@Column(name = "STUDENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;
	@Column(name = "ROLLNUMBER", nullable = false)
	private Integer rollNumber;
	@Column(name = "STANDARD", nullable = false)
	private Integer standard;
	@Column(name = "SECTION", nullable = false)
	private Character section;
	
	
	public Student(String name, Integer rollNumber, Integer standard,
			Character section) {
		super();
		this.name = name;
		this.rollNumber = rollNumber;
		this.standard = standard;
		this.section = section;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(Integer rollNumber) {
		this.rollNumber = rollNumber;
	}

	public Integer getStandard() {
		return standard;
	}

	public void setStandard(Integer standard) {
		this.standard = standard;
	}

	public Character getSection() {
		return section;
	}

	public void setSection(Character section) {
		this.section = section;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
