package com.spring.core.beans;

public class ServiceFactory {
	
	public static MyService getService() {
		return new MyService("This is From Factory", "This is new keyword");
	}

}
