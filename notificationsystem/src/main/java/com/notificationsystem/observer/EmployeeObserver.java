package com.notificationsystem.observer;

import java.util.List;

import com.notificationsystem.model.Employee;
import com.notificationsystem.model.Notification;


public class EmployeeObserver implements Observer {
	
	public EmployeeObserver() {
	}
	
	@Override
	public void update(Notification notification, List<Employee> employees) {
		for (Employee employee: employees) {
			System.out.println("Portal of: "+ "Employee ID: "+ employee.getId() + ": " + notification.getType() + ": " +notification);
		}
	}

	@Override
	public void email(Notification notification, List<Employee> employees) {
		for (Employee employee: employees) {
			System.out.println("Email to: "+ employee.getEmail() + ": " + notification.getType() + ": " +notification);
		}

	}

	@Override
	public void sms(Notification notification, List<Employee> employees) {
		for (Employee employee: employees) {
			System.out.println("SMS to: "  + employee.getPhone() + ": " + notification.getType() + ": " +notification);
		}

	}

}
