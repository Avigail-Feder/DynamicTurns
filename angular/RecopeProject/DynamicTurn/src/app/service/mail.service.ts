import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { BooleanResponse } from '../classes/boolean-responce';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MailService {
  private baseUrl = "http://localhost:8080/web_api/Mail/";

  constructor(private myHttp: HttpClient) { }
  sendMail(): Observable<BooleanResponse> {
    return this.myHttp.get<BooleanResponse>(this.baseUrl + "sendMail");
  }
}
