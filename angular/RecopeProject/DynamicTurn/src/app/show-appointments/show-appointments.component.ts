import { Component, OnInit } from '@angular/core';
import { MeetingsService } from '../service/meetings.service';
import { Meeting } from '../classes/meeting';
import { DestinationsService } from '../service/destinations.service';
import { Destination } from '../classes/destination';
import { Router } from '@angular/router';
import { MessageService } from '../service/message.service';
import { delay } from 'q';
import { ChangeService } from '../service/change.service';
import { Item } from '@syncfusion/ej2-navigations';

@Component({
  selector: 'app-show-appointments',
  templateUrl: './show-appointments.component.html',
  styleUrls: ['./show-appointments.component.css']
})
export class ShowAppointmentsComponent implements OnInit {
  flag:number;
  modal: HTMLElement;
  modalAlert: HTMLElement;
  myId: number;
  friendId: number;
  userMeetings: Meeting[];
  constructor(private router: Router, private destService: DestinationsService, private meetingService: MeetingsService,
    private messagesService: MessageService, private changeService: ChangeService) { }
  appendDestName() {
    this.userMeetings.forEach(item =>
      this.destName(item.id, item.destId));
  }
  destName(elementId, id: string) {
    var destname = "";
    this.destService.getNameById(id).subscribe(dest => {
      destname = dest.firstName + ' ' + dest.lastName;
      document.getElementById(elementId).innerHTML += destname;
    });
  }
  getDestName(id: string) {
    this.destService.getNameById(id).subscribe(dest => {
      console.log('put the name ' + dest.firstName + ' ' + dest.lastName);
      return dest.firstName + ' ' + dest.lastName;
    });
  }
  messageContent(meet: Meeting) {
    console.log('mssageContent');
    this.destService.getNameById(meet.destId).subscribe(dest => {
      this.messagesService.appointmentContent = 'I have a meeting from ' + meet.startTime + ' till ' + meet.endTime + ' to destination ' + dest.firstName + ' ' + dest.lastName + ' and I would like to change it';
      console.log(this.messagesService.appointmentContent);
    });
    const waitFunction = async () => {
      await delay(100);
      this.router.navigate(['/forum']);
    }
    waitFunction();
  }
  routerToForum() {
    this.router.navigate(['/forum']);
  }
  newMessage(meet: Meeting) {
    console.log(meet.startTime);
    console.log(meet.destId);
    var destname = this.getDestName(meet.destId);
    var message = 'I have a meeting from ' + meet.startTime + ' till ' + meet.endTime + ' to destination ' + destname + ' and I would like to change it';
    this.messagesService.appointmentContent = message;
    console.log('beforethe navigate ' + this.messagesService.appointmentContent);
    this.router.navigate(['/forum']);
  } 
  ngOnInit() {
    this.getMeetings();
    this.messagesService.onLoadPage();
  }
  getMeetings() {
    this.meetingService.getMeetingsByUserId().subscribe(data => {
      this.userMeetings = data;
      console.log(this.userMeetings);
      this.appendDestName();
    });
  }
  ModalClose() {
    this.modal.style.display = "none";
  }
  ModalGiving(id: number) {
    console.log('my meeting id is : ' + id);
    this.myId = id;
    this.modal = document.getElementById('myModalChanging');
    this.ModalShow();
  }
  ModalShow() {
    this.modal.style.display = "block";
  }
  ModalAlertClose() {
    this.modalAlert.style.display = "none";
  }
  ModalAlertShow() {
    this.modalAlert.style.display = "block";
  }
  ModalAlertGiving() {
    this.modalAlert = document.getElementById('myModalAlert');
    this.ModalAlertShow();
  }
  onSubmit() {
    this.ModalClose();
    this.changeService.changeInServer(this.myId, this.friendId).subscribe(item => {
      if (item.isTrue == true) {
        document.getElementById('ifShoww').innerHTML = "the changing has done.";
        this.ModalAlertGiving();
        this.getMeetings();
      }
      else {
        document.getElementById('ifShoww').innerHTML = "waiting for partner request.";
        this.ModalAlertGiving();
      }
    });
  }

}
