import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Destination } from '../classes/destination';

@Injectable({
  providedIn: 'root'
})
export class DestinationsService {

  constructor(private myHttp: HttpClient) { }
  destinationChoosen: string;
  baseUrl: string = "http://localhost:8080/web_api/destinations";

  get(): Observable<Destination[]> {
    return this.myHttp.get<Destination[]>(this.baseUrl + "/GET");
  }
  getNameById(id: string): Observable<Destination> {
    return this.myHttp.get<Destination>(this.baseUrl + "/getNameById/"+id);
  }
}
