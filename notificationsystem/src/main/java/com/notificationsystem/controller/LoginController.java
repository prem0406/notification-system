package com.notificationsystem.controller;

import java.util.Optional;

import javax.websocket.server.PathParam;

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
import com.notificationsystem.observer.EmployeeObserver;
import com.notificationsystem.observer.Observer;
import com.notificationsystem.service.EmployeeService;

@RestController
public class LoginController {
	
	private EmployeeService employeeService;
	
	public LoginController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	private EventObservable observable;

	@GetMapping("msg")
	public String getMessage() {
		return "hello";
	}
	
	@PostMapping("notification")
	public void getNotification(@RequestBody Notification notification) {
//		Observable event;
		
		Optional.of(notification.getType()).filter(param -> param.equals(NotificationType.EVENT))
		.ifPresent((param) -> this.observable = EventObservable.getInstance());
		
//		observable.subscribe(new EmployeeObserver());
		
		observable.notifyObservers(notification);
	}
	
	@GetMapping("subscribe/{id}")
	public void subscribe(@PathVariable Long id) {
		Employee emp = employeeService.getEmployeeByID(id);
		
		if (emp != null) {
			observable = EventObservable.getInstance();
			Observer ob = new EmployeeObserver(emp);
			observable.subscribe(ob);
			System.out.println("Subscribed: "+ emp.getId());
		} else {
			throw new NullPointerException();
		}
		
	}
	
	@GetMapping("unsubscribe/{id}")
	public void unsubscribe(@PathVariable Long id) {
		Employee emp = employeeService.getEmployeeByID(id);
		
		if (emp != null) {
			observable = EventObservable.getInstance();
			Observer ob = new EmployeeObserver(emp);
			observable.unsubscribe(ob);
			System.out.println("UnSubscribed: "+ emp.getId());
		} else {
			throw new NullPointerException();
		}
		
	}
	
	@PostMapping("registration")
	public void registerEmployee(@RequestBody EmployeeRegistrationDTO employeeDto) {
		employeeService.saveEmployee(employeeDto);
	}
}
