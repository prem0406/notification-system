package com.notificationsystem.observable;

import com.notificationsystem.model.Employee;
import com.notificationsystem.model.Notification;
import com.notificationsystem.observer.Observer;

public interface Observable {
	public void subscribe(Employee employee);
	public void unsubscribe(Employee employee);
	public void notifyObservers(Notification notification);
}
