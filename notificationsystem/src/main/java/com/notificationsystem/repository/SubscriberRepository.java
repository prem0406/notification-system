package com.notificationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notificationsystem.model.Subscriber;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long>{
	
}
