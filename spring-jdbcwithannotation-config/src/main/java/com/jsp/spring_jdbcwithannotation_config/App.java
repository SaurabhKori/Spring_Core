package com.jsp.spring_jdbcwithannotation_config;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.spring_jdbcwithannotation_config.dao.StudentDao;
import com.jsp.spring_jdbcwithannotation_config.dto.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao st=context.getBean("stdao",StudentDao.class);
//        Student student=new Student(333,"Amit", 38384783);
//        st.insert(student);
//        st.delete(999);
//        st.update(student);
//       System.out.println( st.fetchOnedata(333));
        List<Student> std=st.fetchAlldata();
        for (Student student : std) {
			System.out.println(student);
		}
    }
}
