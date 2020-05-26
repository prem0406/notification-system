package com.notificationsystem.observable;

import java.util.ArrayList;
import java.util.List;

import com.notificationsystem.model.Notification;
import com.notificationsystem.observer.Observer;

public class NagarroNewsObservable implements Observable {

	List<Observer> observers;
	
	public NagarroNewsObservable() {
		this.observers = new ArrayList<Observer>();
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
			ob.update(notification);
			ob.email(notification);
			
		}
		
	}

}
