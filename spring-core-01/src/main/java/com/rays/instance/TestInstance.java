package com.rays.instance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInstance {
	
	
		
		public static void main(String[] args) {

			ApplicationContext context = new ClassPathXmlApplicationContext("instance.xml");

			CreateInstance locator = (CreateInstance) context.getBean("locator");

			CreateInstance s = locator.getInstance();

		}
}
