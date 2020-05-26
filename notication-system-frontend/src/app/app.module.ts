import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterationComponent } from './components/registeration/registeration.component';
import { UserHomeComponent } from './components/user-home/user-home.component';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { UserRegistrationService } from './services/user-registration.service';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    RegisterationComponent,
    UserHomeComponent,
    UserLoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    CommonModule
  ],
  providers: [
    UserRegistrationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
