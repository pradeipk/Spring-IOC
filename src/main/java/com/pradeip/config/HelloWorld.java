package com.pradeip.config;


public class HelloWorld {

	private String str = "Pradeep";

	public void setMessage(String string) {
		System.out.println("Inside set Message----------------- >");
		this.str = string;

	}

	public void getMessage() {
		System.out.println("Inside set Message HelloWorld----------------- > "
				+ this.str);

	}

}
