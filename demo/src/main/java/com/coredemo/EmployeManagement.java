package com.coredemo;

public class EmployeManagement {
	
	private EmailService emailService;
	private EmployeRepo empRepo;
	
	public EmployeManagement() {
		empRepo = new EmployeRepo();
		emailService = new EmailService();
	}
	
	void create() {
		
	}

}
