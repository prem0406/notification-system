package com.notificationsystem.observable;

import java.util.ArrayList;
import java.util.List;

import com.notificationsystem.model.Notification;
import com.notificationsystem.observer.Observer;

public class EventManager implements Observable {
//    Map<String, List<Observer>> listeners = new HashMap<>();
	List<Observer> observers = new ArrayList<Observer>();

//    public EventManager(Observer observer) {
//        observers.add(observer);
//    }

    public void subscribe(Observer observer) {
    	observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Notification notification) {
//        List<Observer> users = listeners.get(eventType);
        for (Observer listener : this.observers) {
            listener.update(notification);
        }
    }
}