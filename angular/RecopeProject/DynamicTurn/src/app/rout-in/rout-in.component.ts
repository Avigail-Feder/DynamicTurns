import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MessageService } from '../service/message.service';

@Component({
  selector: 'app-rout-in',
  templateUrl: './rout-in.component.html',
  styleUrls: ['./rout-in.component.css']
})
export class RoutInComponent implements OnInit {
  firstName: string;

  constructor(private activatedRoute: ActivatedRoute,private messagesService:MessageService) { }
  ngOnInit() {
    this.activatedRoute.params.subscribe(data => this.firstName = data["firstName"]);
    this.messagesService.onLoadPage();
  }

}
