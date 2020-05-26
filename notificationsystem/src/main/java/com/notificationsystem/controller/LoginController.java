package com.notificationsystem.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notificationsystem.dto.EmployeeRegistrationDTO;
import com.notificationsystem.model.Employee;
import com.notificationsystem.model.Notification;
import com.notificationsystem.model.NotificationType;
import com.notificationsystem.observable.Observable;
import com.notificationsystem.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	
	private EmployeeService employeeService;
	private Observable eventObservable;
	private Observable urgentHelpObservable;
	private Observable holidayObservable;
	private Observable nagarroNewsObservable;
	private Observable newPolicyObservable;
	
	public LoginController(EmployeeService employeeService, @Qualifier("eventObservable") Observable eventObservable,
			@Qualifier("urgentHelpObservable")Observable urgentHelpObservable,
			@Qualifier("holidayObservable")Observable holidayObservable,
			@Qualifier("nagarroNewsObservable")Observable nagarroNewsObservable,
			@Qualifier("newPolicyObservable")Observable newPolicyObservable
			) {
		this.employeeService = employeeService;
		this.eventObservable = eventObservable;
		this.urgentHelpObservable = urgentHelpObservable;
		this.holidayObservable = holidayObservable;
		this.nagarroNewsObservable = nagarroNewsObservable;
		this.newPolicyObservable = newPolicyObservable;
	}
	
	
	

	@GetMapping("msg")
	public String getMessage() {
		return "hello";
	}
	
	@PostMapping("notification")
	public void getNotification(@RequestBody Notification notification) {
		
		Optional.of(notification.getType()).filter(param -> param.equals(NotificationType.EVENT))
		.ifPresent((param) -> eventObservable.notifyObservers(notification));
		
		Optional.of(notification.getType()).filter(param -> param.equals(NotificationType.URGENT_HELP))
		.ifPresent((param) -> urgentHelpObservable.notifyObservers(notification));
		
		Optional.of(notification.getType()).filter(param -> param.equals(NotificationType.HOLIDAY))
		.ifPresent((param) -> holidayObservable.notifyObservers(notification));
		
		Optional.of(notification.getType()).filter(param -> param.equals(NotificationType.NAGARRO_NEWS))
		.ifPresent((param) -> nagarroNewsObservable.notifyObservers(notification));
		
		Optional.of(notification.getType()).filter(param -> param.equals(NotificationType.NEW_POLICY))
		.ifPresent((param) -> newPolicyObservable.notifyObservers(notification));
		
		
		
//		observable.notifyObservers(notification);
	}
	
	@GetMapping("subscribe/{id}")
	public void subscribe(@PathVariable Long id) {
		
		Employee emp = employeeService.getEmployeeByID(id);
		
		if (emp != null) {
			urgentHelpObservable.subscribe(emp);
		} else {
			throw new NullPointerException();
		}
		
	}
	
	@GetMapping("unsubscribe/{id}")
	public void unsubscribe(@PathVariable Long id) {
		Employee emp = employeeService.getEmployeeByID(id);
		
		if (emp != null) {
			urgentHelpObservable.unsubscribe(emp);
			
		} else {
			throw new NullPointerException();
		}
		
	}
	
	@PostMapping("registration")
	public void registerEmployee(@RequestBody EmployeeRegistrationDTO employeeDto) {
		employeeService.saveEmployee(employeeDto);
	}
}
