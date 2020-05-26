package com.notificationsystem.observer;

import java.util.List;

import com.notificationsystem.model.Employee;
import com.notificationsystem.model.Notification;

public interface Observer {
    void update(Notification notification, List<Employee> employees);
    void email(Notification notification, List<Employee> employees);
    void sms(Notification notification, List<Employee> employees);
}