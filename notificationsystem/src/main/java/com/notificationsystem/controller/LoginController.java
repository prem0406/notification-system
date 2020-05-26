package com.notificationsystem.controller;

import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notificationsystem.dto.EmployeeRegistrationDTO;
import com.notificationsystem.model.Employee;
import com.notificationsystem.model.Notification;
import com.notificationsystem.model.NotificationType;
import com.notificationsystem.observable.EventObservable;
import com.notificationsystem.observable.Observable;
import com.notificationsystem.service.EmployeeService;

@RestController
public class LoginController {
	
	private EmployeeService employeeService;
	private Observable observable;
	
	public LoginController(EmployeeService employeeService, Observable observable) {
		this.employeeService = employeeService;
		this.observable = observable;
	}
	
	
	

	@GetMapping("msg")
	public String getMessage() {
		return "hello";
	}
	
	@PostMapping("notification")
	public void getNotification(@RequestBody Notification notification) {
		
//		Optional.of(notification.getType()).filter(param -> param.equals(NotificationType.EVENT))
//		.ifPresent((param) -> this.observable = new EventObservable());
		
		observable.notifyObservers(notification);
	}
	
	@GetMapping("subscribe/{id}")
	public void subscribe(@PathVariable Long id) {
		
		Employee emp = employeeService.getEmployeeByID(id);
		
		if (emp != null) {
//			observable = new EventObservable();
			observable.subscribe(emp);
		} else {
			throw new NullPointerException();
		}
		
	}
	
	@GetMapping("unsubscribe/{id}")
	public void unsubscribe(@PathVariable Long id) {
		Employee emp = employeeService.getEmployeeByID(id);
		
		if (emp != null) {
//			observable = new EventObservable();
			observable.unsubscribe(emp);
			
		} else {
			throw new NullPointerException();
		}
		
	}
	
	@PostMapping("registration")
	public void registerEmployee(@RequestBody EmployeeRegistrationDTO employeeDto) {
		employeeService.saveEmployee(employeeDto);
	}
}
