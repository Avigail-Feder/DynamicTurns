import { Component, OnInit } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { Router } from '@angular/router';
import { GetUsersService } from './service/get-users.service';
import { MessageService } from './service/message.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],

})
export class AppComponent implements OnInit {
  // name = 'test';
  // links : any[]= ["link1.com", "link2.com", "link3.com","you have a turn tommorrow"];
  mailText: string = "";
  ngOnInit(): void {
    this.mailText = "mailto:" + this.uesrsService.managerMail + "?subject=concat with the manager";
  }
  title = 'Dynammic Turn';

  constructor(private router: Router, private uesrsService: GetUsersService) { }
  mailMe() {
    window.location.href = this.mailText;
  }

}
