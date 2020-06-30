import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BooleanResponse } from '../classes/boolean-responce';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChangeService {
  baseUrl: string = "http://localhost:8080/web_api/requests";
  constructor(private myHttp: HttpClient) { }
  
  changeInServer(myId:number,freindId:number):Observable<BooleanResponse>{
    console.log('in the service');
    return this.myHttp.get<BooleanResponse>(this.baseUrl+"/change/"+myId+"/"+freindId);
  }
}
