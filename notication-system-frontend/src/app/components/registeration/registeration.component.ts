import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-registeration',
  templateUrl: './registeration.component.html',
  styleUrls: ['./registeration.component.css']
})
export class RegisterationComponent implements OnInit {
  userForm : FormGroup;

  firstNameControl: FormControl;
  lastNameControl: FormControl;
  emailControl: FormControl;
  phoneControl: FormControl;
  notificationControl: FormControl;


  constructor() { }

  ngOnInit(): void {
    this.firstNameControl = new FormControl('');
    this.lastNameControl = new FormControl('');
    this.emailControl = new FormControl('');
    this.phoneControl = new FormControl('');
    this.notificationControl = new FormControl('');

    this.userForm = new FormGroup({
      firstName: this.firstNameControl,
      lastName: this.lastNameControl,
      email: this.emailControl,
      phone: this.phoneControl,
      notification: this.notificationControl
    })
  }


  onFormSubmit(){
    console.log(this.userForm.value)
  }
}
