package com.notificationsystem.observable;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.notificationsystem.model.Employee;
import com.notificationsystem.model.Notification;
import com.notificationsystem.model.Subscriber;
import com.notificationsystem.observer.EmployeeObserver;
import com.notificationsystem.observer.Observer;
import com.notificationsystem.service.SubscriberService;

@Component
public class UrgentHelpObservable implements Observable {

	private static final Long id = 2L;
	
	
	Observer ob;
	
	List<Employee> employees;
	
	Subscriber subscribers;
	
	SubscriberService service;
	
	public UrgentHelpObservable(SubscriberService service) {

		this.service = service;
		this.ob = new EmployeeObserver();
		subscribers = service.findByID(id).get();
	}
	
	
	@Override
	public void subscribe(Employee employee) {

		employee.getSubscriptionType().add(this.subscribers);
		this.subscribers.getEmployees().add(employee);
		
		service.save(this.subscribers);
		
	}
	@Override
	public void unsubscribe(Employee employee) {
		
		employee.getSubscriptionType().remove(this.subscribers);
		this.subscribers.getEmployees().remove(employee);
		
		service.save(this.subscribers);
		
	}

	@Override
	public void notifyObservers(Notification notification) {
		Optional<Subscriber> op = service.findByID(id);
		if(op.isPresent()) {
			this.subscribers = op.get();
		}
			ob.email(notification, this.subscribers.getEmployees());
			ob.sms(notification, this.subscribers.getEmployees());	
	}

}
