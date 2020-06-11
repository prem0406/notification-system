import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Notification } from 'src/app/models/notification.interface';

@Component({
  selector: 'app-notification-control',
  templateUrl: './notification-control.component.html',
  styleUrls: ['./notification-control.component.css']
})
export class NotificationControlComponent implements OnInit {
  userForm: FormGroup;
  notification: Notification;
  constructor() { }

  ngOnInit(): void {

    this.userForm = new FormGroup({
      type: new FormControl('',[Validators.required]),
      message: new FormControl('',[Validators.required])
    });
  }


  onFormSubmit(){
    console.log(this.userForm.value);
    this.notification = this.userForm.value;
    console.log(this.notification);
  }

}
