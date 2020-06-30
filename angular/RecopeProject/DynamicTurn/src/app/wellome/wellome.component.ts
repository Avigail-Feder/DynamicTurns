import { Component, OnInit } from '@angular/core';
import { GetUsersService } from '../service/get-users.service';
import { Router } from '@angular/router';
import { MeetingsService } from '../service/meetings.service';
import { MailService } from '../service/mail.service';

@Component({
  selector: 'app-wellome',
  templateUrl: './wellome.component.html',
  styleUrls: ['./wellome.component.css']
})
export class WellomeComponent implements OnInit {
  constructor(public getus: GetUsersService, private router: Router, private meetingService: MeetingsService, private mailService: MailService) { }
  isIn: boolean = false;
  modal: HTMLElement;
  modelpassword: HTMLElement;
  modalwarning: HTMLElement;
  tryPassword: string;
  tryId: string;
  tryFirstName: string;
  tryLastName: string;
  tryAddress: string;
  tryTelephone: string;
  tryEmail: string;
  sighIn() {
    this.getus.isIn(this.first_name, this.last_name, this.password).subscribe(item => {
      if (item.isTrue == false) {
        this.ModalWarningShow();
      }
      else {
        this.getus.isManager(this.password, this.first_name, this.last_name).subscribe(i => {
          if (i.isTrue == true)
            this.router.navigate(['/manager'])
        });

        this.getus.getUser(this.password, this.first_name, this.last_name).subscribe(user => {
          console.log('user id is: ' + user.id);
          this.getus.user = user;
          this.meetingService.userId = user.id;
        });
      
        this.router.navigate(['/rout-in']);
      }
    });
  }
  sendMail() {
    this.mailService.sendMail().subscribe(item => {
      if (item.isTrue == true)
        console.log("the mail sended!!!");
      else console.log("the mail did nottttt");
    });
  }
  forgetPass() {
    this.modal = document.getElementById('myModalWarning');
    this.ModalShow();
  }
  ModalClose() {
    this.modal.style.display = "none";
  }
  ModalShow() {
    this.modal.style.display = "block";
    window.scrollTo(0,0);
  }
  ModelPasswordShow() {
    this.ModalClose();
    this.modelpassword.style.display = "block";
    window.scrollTo(0,0);
  }
  passwordMessage() {
    this.ModelPasswordShow();
  }
  ModalPasswordClose() {
    this.modelpassword.style.display = "none";
  }
  ModalWarningShow() {
    this.modalwarning.style.display = "block";
    window.scrollTo(0,0);


  }
  ModalWarningClose() {
    this.modalwarning.style.display = "none";
  }
  first_name: string = "";
  last_name: string = "";
  password: string = "";

  next() {
    var firstIndex, lastIndex;
    this.getus.getUserById(this.tryId).subscribe(u => {
      if (u != null && this.tryFirstName == u.first_name && this.tryLastName == u.last_name &&
        this.tryAddress == u.address && this.tryEmail == u.email && this.tryTelephone == u.telephone) {
        console.log('every is same');
        firstIndex = u.password.indexOf(this.tryPassword[0]);
        lastIndex = u.password.lastIndexOf(this.tryPassword[1]);
        if (firstIndex != -1 && lastIndex != -1 && firstIndex != lastIndex) {
          console.log('display password');
          document.getElementById("ifShoww").innerHTML = "your password is " + u.password;
          this.passwordMessage();
        }
        else {
          console.log('password is not suit');
          document.getElementById("ifShoww").innerHTML = "sorry, your inputs that you press are not suitable.";
          this.passwordMessage();
        }
      }
      else {
        console.log('details are not suit');
        document.getElementById("ifShoww").innerHTML = "sorry, you are not sigh in.";
        this.passwordMessage();
      }
    });
  }
  ngOnInit() {
    this.modelpassword = document.getElementById('myModalPassword');
    this.modalwarning = document.getElementById('myModal');
  }
}
