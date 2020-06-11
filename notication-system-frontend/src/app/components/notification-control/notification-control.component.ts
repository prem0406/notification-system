import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Notification } from 'src/app/models/notification.interface';
import { NotificationService } from 'src/app/services/notification.service';

@Component({
  selector: 'app-notification-control',
  templateUrl: './notification-control.component.html',
  styleUrls: ['./notification-control.component.css']
})
export class NotificationControlComponent implements OnInit {
  userForm: FormGroup;
  notification: Notification;
  constructor(private service : NotificationService) { }

  ngOnInit(): void {

    this.userForm = new FormGroup({
      type: new FormControl('',[Validators.required]),
      message: new FormControl('',[Validators.required])
    });
  }


  onFormSubmit(){
    // console.log(this.userForm.value);
    this.notification = this.userForm.value;
    this.service.sendNotification(this.notification).subscribe(() =>
    console.log('success..'), error => console.log('error...', error));
    // console.log(this.notification);


  }

}
