package com.pradeip.spring;

import org.springframework.beans.factory.annotation.Required;

public class Communication {
	private Messaging messaging;
	private Integer inValue ;

	/*
	 * DI via Setter
	 * Should you comment setter and you will get below error
	 * Bean property 'messaging' is not writable or has an invalid setter method. 
	 * Does the parameter type of the setter match the return type of the getter?
	 * see app-config.xml , when instantiating Communication pass ref as messaging 
	 */

	public void setMessaging(Messaging messaging) {
		this.messaging = messaging;
		getInValue();
	}
	
	
	public Integer getInValue() {
		System.out.println("Printing Invalue : " + this.inValue);
		return this.inValue;
	}
	
	
	public void setInValue(Integer inValue) {
		this.inValue = inValue;
	}

	public void communicate() {
		messaging.sendMessage();
	}
}

/** 
 *    For setter Based DI setter is required 
 *    For Constructor Based DI parametric constructor is required
 */
