package com.pradeip.hibernate.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pradeip.hibernate.Student;
import com.pradeip.hibernate.dao.StudentDaoImpl;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	
	
	@Autowired
	private StudentDaoImpl daoImpl;

	@Override
	public void save(Student student) {
		daoImpl.save(student);
		
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> T criteria(T dto) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	

}
