package com.notificationsystem.observable;

import java.util.ArrayList;
import java.util.List;

import com.notificationsystem.model.Notification;
import com.notificationsystem.observer.Observer;

public class EventObservable implements Observable {
	List<Observer> observers;
	
	private static EventObservable instance= new EventObservable();
	
	private EventObservable() {
		this.observers = new ArrayList<Observer>();
	}
	
	public static EventObservable getInstance() {
		return instance;
	}
	
	@Override
	public void subscribe(Observer observer) {
		this.observers.add(observer);
		
	}

	@Override
	public void unsubscribe(Observer observer) {
		this.observers.remove(observer);
		
	}

	@Override
	public void notifyObservers(Notification notification) {
		for (Observer ob: observers) {
			ob.email(notification);
			ob.update(notification);
		}
		
	}

}
