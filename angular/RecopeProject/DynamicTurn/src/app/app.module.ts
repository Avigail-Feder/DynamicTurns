import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ScheduleModule } from '@syncfusion/ej2-angular-schedule';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { WellomeComponent } from './wellome/wellome.component';
import { RegisterComponent } from './register/register.component';


import { RoutInComponent } from './rout-in/rout-in.component';
import { ChooseDestinationComponent } from './choose-destination/choose-destination.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { ManagerComponent } from './manager/manager.component';
import { SeeUsersComponent } from './see-users/see-users.component';
import { ForumComponent } from './forum/forum.component';
import { ShowAppointmentsComponent } from './show-appointments/show-appointments.component';
import { ValidationDirective } from './validation.directive';
import { TryComponent } from './try/try.component';
import { AllScheduleComponent } from './all-schedule/all-schedule.component';
import { HomeComponent } from './home/home.component';
import { MatSliderModule } from '@angular/material/slider';




@NgModule({
  declarations: [
    AppComponent,

    WellomeComponent,

    RegisterComponent,

    RoutInComponent,

    ChooseDestinationComponent,

    ScheduleComponent,

    ManagerComponent,

    SeeUsersComponent,

    ForumComponent,

    ShowAppointmentsComponent,

    ValidationDirective,

    TryComponent,

    AllScheduleComponent,

    HomeComponent

  ],
  imports: [
    ScheduleModule,
    FormsModule,
    AppRoutingModule,
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatSliderModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
