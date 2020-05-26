import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { API_URL } from '../app.constant';
import {Employee} from '../models/employee.interface'

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  constructor(private http: HttpClient) { }

  createUser(employee: Employee ){
    return this.http.post(`${API_URL}/registration`, employee);
  }
}
