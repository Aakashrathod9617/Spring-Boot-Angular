package com.rays.primary;

public class NotificationService {
	
	
	private MessageService service;

	public void setService(MessageService service) {
		this.service=service;
	}


	public void sendNotification(String message) {
		service.sendMessage(message);
	}
	
	

}
