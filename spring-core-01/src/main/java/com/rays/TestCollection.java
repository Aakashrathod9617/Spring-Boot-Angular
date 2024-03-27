package com.rays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rays.collection.MyBean;

public class TestCollection {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("collection.xml");
		MyBean myBean = (MyBean) context.getBean("myBean");
		myBean.displayData();

	}


}
