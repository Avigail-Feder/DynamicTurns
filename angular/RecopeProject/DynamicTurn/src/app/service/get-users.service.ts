import { Injectable } from '@angular/core';
import { User } from '../classes/user';

import { Observable } from 'rxjs/internal/Observable';
import { BooleanResponse } from '../classes/boolean-responce';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class GetUsersService {
private baseUrl = "http://localhost:8080/web_api/"
  user: User;
  managerMail: string='manager@gmail.com';
  constructor(private myHttp: HttpClient) { }

  isIn(first: string, last: string, pass: string): Observable<BooleanResponse> {
    return this.myHttp.get<BooleanResponse>(this.baseUrl + "Users/Login/" + first + "/" + last + "/" + pass);
  }
  add(user: User): Observable<BooleanResponse> {
    if (user.isManager)
      this.managerMail = user.email;
    return this.myHttp.post<BooleanResponse>(this.baseUrl + "Users/add", user);

  }
  delete(id: string): Observable<BooleanResponse> {
    return this.myHttp.post<BooleanResponse>(this.baseUrl + 'Users/delete', id);
  }
  update(user: User): Observable<BooleanResponse> {
    return this.myHttp.put<BooleanResponse>(this.baseUrl + 'Users/update', user)
  }
  getUsers(): Observable<User[]> {
    return this.myHttp.get<User[]>(this.baseUrl + 'Users/getUsers');
  }
  isManager(password: string, firstName: string, lastName: string): Observable<BooleanResponse> {
    return this.myHttp.get<BooleanResponse>(this.baseUrl + 'Users/isManager/' + password + '/' + firstName + '/' + lastName);
  }
  getUser(password: string, firstName: string, lastName: string): Observable<User> {
    return this.myHttp.get<User>(this.baseUrl + 'Users/getUser/' + password + '/' + firstName + '/' + lastName);
  }
  getUserById(id: string): Observable<User> {
    return this.myHttp.get<User>(this.baseUrl + 'Users/getUserById' + '/' + id);
  }
}
