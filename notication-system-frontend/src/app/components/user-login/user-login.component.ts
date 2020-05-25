import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  userForm : FormGroup;

  usernameControl: FormControl;
  passwordControl: FormControl;



  constructor() { }

  ngOnInit(): void {
    this.usernameControl = new FormControl('');
    this.passwordControl = new FormControl('');

    this.userForm = new FormGroup({
      username: this.usernameControl,
      password: this.passwordControl
    })
  }


  onFormSubmit(){
    console.log(this.userForm.value)
  }

}
