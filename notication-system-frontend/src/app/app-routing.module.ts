import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterationComponent } from './components/registeration/registeration.component';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { NotificationControlComponent } from './components/notification-control/notification-control.component';


const routes: Routes = [
  {path: '', component: UserLoginComponent, pathMatch: 'full'},
  {path: 'registration', component: RegisterationComponent},
  {path: 'notification', component: NotificationControlComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
