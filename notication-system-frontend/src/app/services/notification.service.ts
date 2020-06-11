import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Notification} from '../models/notification.interface'
import { API_URL } from '../app.constant';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private http: HttpClient) { }

  sendNotification(notification: Notification){
    return this.http.post(`${API_URL}/notification`, notification);
  }
}
