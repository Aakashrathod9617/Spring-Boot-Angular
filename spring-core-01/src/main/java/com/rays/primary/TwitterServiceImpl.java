package com.rays.primary;

public class TwitterServiceImpl implements MessageService {

	public void sendMessage(String message) {
	
		System.out.println("Sending tweet: " + message);
		
	}

}
