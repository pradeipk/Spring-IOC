package com.pradeip.hibernate.dao;

import org.springframework.stereotype.Repository;

import com.pradeip.hibernate.Student;

@Repository
public class StudentDaoImpl extends BaseDao<Student, Long> {
	

	@Override
	public void save(Student entity) {
		super.save(entity);
	}

	@Override
	public void update(Student entity) {
		super.update(entity);
	}

	@Override
	public void delete(Student entity) {
		super.delete(entity);
	}

	@Override
	public Student findById(Long pk) {
		return super.findById(pk);
	}

}
