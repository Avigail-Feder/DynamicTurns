import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Message } from '../classes/message';
import { BooleanResponse } from '../classes/boolean-responce';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  appointmentContent: string;
  private baseUrl = "http://localhost:8080/web_api/";
  constructor(private myHttp: HttpClient) { }
  getMessages(): Observable<Message[]> {
    return this.myHttp.get<Message[]>(this.baseUrl + 'Messages/getMessages');
  }
  addMessage(message: Message): Observable<BooleanResponse> {
    return this.myHttp.post<BooleanResponse>(this.baseUrl + 'Messages/addMessage', message);
  }
  interval: any;
  flag: number = 0;
  onLoadPage(interv?) {
    if (this.flag && window.location.href == "http://localhost:4200/forum") {
      this.interval = interv;
      console.log('seinterval')
    }
    else if (this.flag && window.location.href != "http://localhost:4200/forum") {
      clearInterval(this.interval);
      console.log('clearinterval')
    }
  }
}
