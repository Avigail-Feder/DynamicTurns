import { Component, OnInit } from '@angular/core';
import { GetUsersService } from '../service/get-users.service';
import { User } from '../classes/user';
import { Router } from '@angular/router';
import { delay } from 'q';

@Component({
  selector: 'app-see-users',
  templateUrl: './see-users.component.html',
  styleUrls: ['./see-users.component.css']
})
export class SeeUsersComponent implements OnInit {


  constructor(private getUsers: GetUsersService, private router: Router) { }
  users: User[];
  modal: HTMLElement;
  id: string;
  ngOnInit() {
    this.getUsers.getUsers().subscribe(data => this.users = data);
    const yourFunction = async () => {
      await delay(100);
      this.users.forEach(element => {
        element.identity=this.users.indexOf(element);
      });
    }
    yourFunction();
  }
  playForm: boolean[] = [false];
  ModalClose() {
    this.modal.style.display = "none";
  }
  ModalGiving(id: string) {
    this.id = id;
    this.modal = document.getElementById('myModalWarning');
    this.ModalShow();
  }
  ModalShow() {
    this.modal.style.display = "block";
  }
  delete() {
    console.log('id ' + this.id);
    this.getUsers.delete(this.id).subscribe(i => {
      if (i.isTrue == true) {
      console.log("delete");
      }
      else console.log("not delete");
    });
    this.ModalClose();
    this.getUsers.getUsers().subscribe(data=>this.users=data);
    const yourFunction = async () => {
      await delay(100);
      this.users.forEach(element => {
        element.identity=this.users.indexOf(element);
      });
    }
    yourFunction();
  }

  user: User = new User("", "", "", "", "", "", "", false);
  update(i: number, fName: string, lName: string, id: string, address: string, tel: string, pass: string, email: string) {
    this.user.first_name = fName;
    this.user.last_name = lName;
    this.user.id = id;
    this.user.address = address;
    this.user.telephone = tel;
    this.user.password = pass;
    this.user.email = email;
    this.getUsers.update(this.user).subscribe(i => {
      if (i.isTrue == true){
        this.getUsers.getUsers().subscribe(data=>this.users=data);
        const yourFunction = async () => {
          await delay(100);
          this.users.forEach(element => {
            element.identity=this.users.indexOf(element);
          });
        }
        yourFunction();
      }
      else console.log("not update");
    });
    this.closeForm(i);
  }

  openForm(i: number) {
    !this.playForm[i] ? this.playForm[i] = true : this.closeForm(i);
  }

  closeForm(i: number) {
    this.playForm[i] = false;
  }

}
