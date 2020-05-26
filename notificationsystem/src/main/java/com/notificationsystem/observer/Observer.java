package com.notificationsystem.observer;

import com.notificationsystem.model.Notification;

public interface Observer {
    void update(Notification notification);
    void email(Notification notification);
    void sms(Notification notification);
}