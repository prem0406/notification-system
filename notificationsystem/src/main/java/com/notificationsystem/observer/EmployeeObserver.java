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
			System.out.println("Portal: "+notification  + employee.getId());
		}
	}

	@Override
	public void email(Notification notification, List<Employee> employees) {
		for (Employee employee: employees) {
			System.out.println("Email: "+notification + employee.getEmail());
		}

	}

	@Override
	public void sms(Notification notification, List<Employee> employees) {
		for (Employee employee: employees) {
			System.out.println("SMS: "+notification + employee.getPhone());
		}

	}

}
