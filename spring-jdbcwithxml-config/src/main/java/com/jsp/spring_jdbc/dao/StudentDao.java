package com.jsp.spring_jdbc.dao;

import java.util.List;
/**
 * @author Saurabh
 */

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.jsp.spring_jdbc.dto.Student;

public class StudentDao {
	private JdbcTemplate jdbctemplate;
//	insert data into database
	public void insertdata(Student student) {
		String insert="Insert into studentdetail(studentId,studentName,studentPhone) value(?,?,?)";
	this.jdbctemplate.update(insert,student.getStudentId(),student.getStudentName(),student.getStudentPhone());
	System.out.println("Insert data.......");
	}
	// update Date 
	public void update(Student student) {
		String update="update studentdetail set studentName=?,studentPhone=? where studentId=?";
		this.jdbctemplate.update(update,student.getStudentName(),student.getStudentPhone(),student.getStudentId());
		System.out.println("Update data........");
	}
//	delete one data from database
	public void delete(int studentId) {
		String delete="delete from studentdetail where studentId=?";
		this.jdbctemplate.update(delete,studentId);
		System.out.println("Delete data............");
	}
//	fetch one Data from Data base by implement RowMapper Interface
	
	public Student getOneDate(int id) {
		String fetch="Select * from studentdetail where studentId=?";
		RowMapper<Student> rowMapper=new RowMapperImple();
		return this.jdbctemplate.queryForObject(fetch,rowMapper,id);
	}
	// fetch all data from database by query method which are present JdbcTemplet class and implement Rowmapper Interface
	public List<Student> getAlldata(){
		String fetch="select * from studentdetail";
		return this.jdbctemplate.query(fetch, new RowMapperImple());
	}
	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}
	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	

}
