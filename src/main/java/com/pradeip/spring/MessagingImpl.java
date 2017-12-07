package com.pradeip.spring;

public class MessagingImpl implements Messaging {

	public void sendMessage() {
		System.out.println("Sending Message via Active MQ");
	}
}