package com.notificationsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.notificationsystem.model.Employee;
import com.notificationsystem.model.Subscriber;
import com.notificationsystem.repository.SubscriberRepository;

@Service
public class SubscriberServiceImpl implements SubscriberService {

	SubscriberRepository subscriberRepo;
	
	public SubscriberServiceImpl(SubscriberRepository subscriberRepo) {
		this.subscriberRepo = subscriberRepo;
	}
	
	@Override
	public Optional<Subscriber> findByID(Long id) {
		Optional<Subscriber> op = subscriberRepo.findById(id);
		return op;
	}

	@Override
	public Subscriber save(List<Employee> employees, Long id) {
		Subscriber sub = new Subscriber(id , employees);
		return subscriberRepo.save(sub);
	}

	@Override
	public Subscriber save(Subscriber subscriber) {
		return subscriberRepo.save(subscriber);
	}

}
