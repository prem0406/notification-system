package com.notificationsystem.observable;

import java.util.ArrayList;
import java.util.List;

import com.notificationsystem.model.Notification;
import com.notificationsystem.observer.Observer;

public class UrgentHelpObservable implements Observable {

List<Observer> observers;
	
	public UrgentHelpObservable() {
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
			ob.email(notification);
			ob.sms(notification);
		}
		
	}

}
