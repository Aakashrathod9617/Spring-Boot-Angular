package com.rays.instance;

public  class CreateInstance {

	
	private static CreateInstance instance;

	private CreateInstance(){
	}

	public static CreateInstance getInstance() {
		if (instance == null) {
			instance = new CreateInstance();
		}
		System.out.println("sky");
		return instance;
	}
}