package com.jsp.spring_jdbc;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jsp.spring_jdbc.dao.StudentDao;
import com.jsp.spring_jdbc.dto.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      ApplicationContext context =new ClassPathXmlApplicationContext("jdbc.xml");
//     JdbcTemplate jdbc= context.getBean("jdbc",JdbcTemplate.class);
      StudentDao s=context.getBean("std",StudentDao.class);
//      Student student=context.getBean("student",Student.class);
//      s.insertdata(new Student(333,"hinaa", 9964736));
//      s.update(new Student(565,"Rahul",6763888));
//      s.delete(666);
//      System.out.println(s.getOneDate(111));
      List<Student> st=s.getAlldata();
      for (Student student : st) {
		System.out.println(student);
	}
	
    }
}
