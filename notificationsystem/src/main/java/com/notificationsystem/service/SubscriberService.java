package com.notificationsystem.service;

import java.util.List;
import java.util.Optional;

import com.notificationsystem.model.Employee;
import com.notificationsystem.model.Subscriber;

public interface SubscriberService {
	public Optional<Subscriber> findByID(Long id);
	public Subscriber save(List<Employee> employees, Long id);
	public Subscriber save(Subscriber subscriber);
}
