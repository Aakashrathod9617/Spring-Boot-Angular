package com.rays.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMultiple {

	public static void main(String[] args) {
		
		ApplicationContext context= new ClassPathXmlApplicationContext("TestMultiple.xml");
		
		Person person=(Person)context.getBean(Person.class);
		Student student=(Student)context.getBean(Student.class);
		
		System.out.println("Person ="+person.getName());
		System.out.println("Student Name"+ student.getName());
		System.out.println("Student LoginId"+ student.getLoginId());
		System.out.println("Student Password"+ student.getPassword());
		
	}
}
