package com.notificationsystem.observer;

import com.notificationsystem.model.Employee;
import com.notificationsystem.model.Notification;

public class EmployeeObserver implements Observer {
	private Employee employee;
	
	public EmployeeObserver(Employee employee) {
		this.employee = employee;
	}
	
	@Override
	public void update(Notification notification) {
		System.out.println("Portal: "+notification  + employee.getId());

	}

	@Override
	public void email(Notification notification) {
		System.out.println("Email: "+notification + employee.getEmail());

	}

	@Override
	public void sms(Notification notification) {
		System.out.println("SMS: "+notification);

	}

}
