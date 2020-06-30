import { Component, OnInit, Input } from '@angular/core';
import { MessageService } from '../service/message.service';
import { Message } from '../classes/message';
import { GetUsersService } from '../service/get-users.service';
import { delay } from 'q';


@Component({
  selector: 'app-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {
  messages: Message[];
  @Input() content: string;
  elmnt: Element;
  interval: any;
  constructor(private messagesService: MessageService, private usersService: GetUsersService) {

    // this.interval = setInterval(this.waitFunction, 4000);
  }

  ngOnInit() {
    this.getMessages();
    console.log(this.messagesService.appointmentContent);
    if (this.messagesService.appointmentContent) {
      this.content = this.messagesService.appointmentContent;
      // this.addMessage(13);
    }
    this.loading();
    setTimeout(this.scrollFromBottom, 1000);
    this.messagesService.flag = 1;
    this.interval = setInterval(this.waitFunction, 5000);
    this.messagesService.onLoadPage(this.interval);
  }
  waitFunction = async () => {
    console.log('waitFunction');
    await delay(100);
    this.getMessages();
  }
  getMessages() {
    this.messagesService.getMessages().subscribe(data => {
      this.messages = data;
      console.log(this.messages);
      this.appendNameToMessage();
      setTimeout(this.scrollFromBottom, 100);
    });
  }
  loading() {
    setTimeout(this.showPage, 1500);
  }
  showPage() {
    document.getElementById("loader").style.display = "none";
    document.getElementById("myDiv").style.display = "block";
    //setInterval(this.appendNameToMessage, 1500);
    // setInterval(this.appendUserName, 1500);
  }
  appendNameToMessage() {
    this.messages.forEach(item => this.appendUserName(item.code, item.userId));
  }
  appendUserName(elementId, id: string) {
    var fullUserName = "";
    this.usersService.getUserById(id).subscribe(user => {
      fullUserName = user.first_name + ' ' + user.last_name;
      console.log('full user name : ' + fullUserName);
      document.getElementById(elementId).innerHTML = fullUserName + " saying...";
    });
  }
  scrollFromBottom() {
    this.elmnt = document.getElementById('chatOld');
    this.elmnt.scrollTop = this.elmnt.scrollHeight;
  }
  addThisMessage() {
    if (this.content) {
      this.messages.push(new Message(this.messages.length + 1, this.usersService.user.id, this.content));
      console.log(this.usersService.user.id);
      console.log(this.content);
      this.messagesService.addMessage(new Message(this.messages.length + 1, this.usersService.user.id, this.content)).subscribe(
        i => {
          if (i.isTrue == true)
            console.log("message added")
          else console.log("message didnt add");
        }
      );
      this.content = "";
      setTimeout(this.scrollFromBottom, 100);
    }
  }
  addMessage(e) {
    console.log(e);
    if (e == 13) {
      this.addThisMessage();
    }
  }
}
