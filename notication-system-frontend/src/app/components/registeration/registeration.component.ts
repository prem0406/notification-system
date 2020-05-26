import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Employee } from 'src/app/models/employee.interface';
import {UserRegistrationService} from 'src/app/services/user-registration.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registeration',
  templateUrl: './registeration.component.html',
  styleUrls: ['./registeration.component.css']
})
export class RegisterationComponent implements OnInit {
  userForm : FormGroup;
  employee: Employee;

  firstNameControl: FormControl;
  lastNameControl: FormControl;
  emailControl: FormControl;
  phoneControl: FormControl;
  notificationControl: FormControl;
  officeLocationControl: FormControl;


  constructor(private service: UserRegistrationService,
    private router: Router) { }

  ngOnInit(): void {
    this.firstNameControl = new FormControl('');
    this.lastNameControl = new FormControl('');
    this.emailControl = new FormControl('');
    this.phoneControl = new FormControl('');
    this.notificationControl = new FormControl('');
    this.officeLocationControl = new FormControl('');

    this.userForm = new FormGroup({
      firstName: this.firstNameControl,
      lastName: this.lastNameControl,
      email: this.emailControl,
      phone: this.phoneControl,
      // notification: this.notificationControl,
      officeLocation: this.officeLocationControl
    })
  }


  onFormSubmit(){
    console.log(this.userForm.value);
    this.employee = this.userForm.value;
    this.service.createUser(this.employee).subscribe((data) => {
      alert('Registration Successful!');
      this.router.navigate(['']);
    })
  }
}
