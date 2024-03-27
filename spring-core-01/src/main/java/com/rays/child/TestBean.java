package com.rays.child;

public class TestBean {

	private String name;
	private String age;
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "TestBean [name=" + name + ", age=" + age + "]";
	}
	
}
