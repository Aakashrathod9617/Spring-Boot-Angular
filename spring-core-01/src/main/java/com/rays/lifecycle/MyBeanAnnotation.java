package com.rays.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MyBeanAnnotation {
	
	
	@PostConstruct
	public void init() {
		System.out.println("this is init method");
	}
	
	
	@PreDestroy
	public void destroy() {
		
		System.out.println("this is destroy method");
	}

}
