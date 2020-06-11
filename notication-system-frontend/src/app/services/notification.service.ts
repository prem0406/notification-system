import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Notification} from '../models/notification.interface'

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private http: HttpClient) { }

  sendNotification(notification: Notification){

  }
}
