import { WellomeComponent } from './wellome/wellome.component';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { NgModule } from '@angular/core';
import { RoutInComponent } from './rout-in/rout-in.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { ChooseDestinationComponent } from './choose-destination/choose-destination.component';
import { SeeUsersComponent } from './see-users/see-users.component';
import { ManagerComponent } from './manager/manager.component';
import { ForumComponent } from './forum/forum.component';
import { ShowAppointmentsComponent } from './show-appointments/show-appointments.component';
import { TryComponent } from './try/try.component';
import { AllScheduleComponent } from './all-schedule/all-schedule.component';
import { HomeComponent } from './home/home.component';



const appRoutes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'wellcome', component: WellomeComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'rout-in', component: RoutInComponent },
  { path: 'schedule', component: ScheduleComponent },
  { path: 'choose-destination', component: ChooseDestinationComponent },
  { path: 'manager', component: ManagerComponent },
  { path: 'see-users', component: SeeUsersComponent },
  { path: 'forum', component: ForumComponent },
  { path: 'show-appintments', component: ShowAppointmentsComponent },
  { path: 'try', component: TryComponent },
  { path: 'all-schedule', component: AllScheduleComponent },
  { path: '**', redirectTo: '/not-found' }

];
@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [RouterModule]
})

export class AppRoutingModule { }