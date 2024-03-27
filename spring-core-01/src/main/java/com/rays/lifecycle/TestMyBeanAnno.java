package com.rays.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyBeanAnno {
public static void main(String[] args) {
		
		
		ApplicationContext context= new ClassPathXmlApplicationContext("LifeCycle2.xml");
	    
	MyBeanAnnotation bean=(MyBeanAnnotation)context.getBean("myBeanAnno");
	
     ((ClassPathXmlApplicationContext) context).close();
	
	}

}


