package com.notificationsystem.observable;

import com.notificationsystem.model.Notification;
import com.notificationsystem.observer.Observer;

public interface Observable {
	public void subscribe(Observer observer);
	public void unsubscribe(Observer observer);
	public void notifyObservers(Notification notification);
}
