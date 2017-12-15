package com.pradeip.hibernate.service;

import com.pradeip.hibernate.Student;

public interface StudentService {
	
	public void save(Student student);
	public void update(Student student);
	public void delete(Student student);
	public <T> T criteria(T dto);
	

}
