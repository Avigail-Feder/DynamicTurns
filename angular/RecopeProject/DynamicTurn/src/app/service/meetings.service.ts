import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, observable } from 'rxjs';
import { Meeting } from '../classes/meeting';
import { DestinationsService } from './destinations.service';
import { BooleanResponse } from '../classes/boolean-responce';

@Injectable({
  providedIn: 'root'
})
export class MeetingsService {

  private baseUrl = "http://localhost:8080/web_api/meetings/";
  destId: string;
  userId: string;
  
  getMeetingsByDestId(): Observable<Meeting[]> {
    this.destId = this.destinaionService.destinationChoosen;
    console.log('custome id ' + this.userId);
    console.log('get meeting that its destId is: ' + this.destId)
    return this.myHttp.get<Meeting[]>(this.baseUrl + "getMeetindsByDestId/" + this.destId);
  }
  getMeetings():Observable<Meeting[]>{
    return this.myHttp.get<Meeting[]>(this.baseUrl + "getMeetings/");
  }
  getMeetingsByUserId():Observable<Meeting[]> {
    return this.myHttp.get<Meeting[]>(this.baseUrl + "getMeetingsByUserId/" + this.userId);
  }
  saveMeetings(meets:Meeting[]):Observable<BooleanResponse>{
    console.log('in save meeting in service');
    return this.myHttp.post<BooleanResponse>(this.baseUrl + "add",meets);
  }
  constructor(private myHttp: HttpClient, private destinaionService: DestinationsService) {

  }
}
