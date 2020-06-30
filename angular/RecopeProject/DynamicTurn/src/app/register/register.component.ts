import { Component, OnInit } from '@angular/core';
import { GetUsersService } from '../service/get-users.service';
import { User } from '../classes/user';
import { Router } from '@angular/router';
import { delay } from 'q';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  model: any = {};

  onSubmit() {
    // alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.model));
    this.addUser();
  }

  firstName: string;
  lastName: string;
  telephone: string;
  address: string;
  id: string;
  email: string;
  password: string;
  modal: HTMLElement;
  flag: boolean;
  constructor(public users: GetUsersService, private router: Router) {
  }
  ModalClose() {
    this.modal.style.display = "none";
    this.router.navigate(['']);
  }
  ModalShow() {
    this.modal.style.display = "block";
    window.scrollTo(0,0);
  }

  addUser() {
    var flag = 0;
    this.users.add(new User(this.model.firstName, this.model.lastName, this.model.telephone, this.model.address, this.model.id, this.model.email, this.model.password, false)).subscribe(
      item => {
        if (item.isTrue == true) {
          flag = 1;
        }
      });
    const yourFunction = async () => {
      await delay(100);
      if (flag) {
        console.log('the registration succeeded');
        document.getElementById("ifShow").innerHTML = "the registration succeeded.";
        this.ModalShow();
      }
      else {
        console.log('the registration did not succeed');
        document.getElementById("ifShow").innerHTML = "the registration did not succeed.";
        this.ModalShow();
      }
      //here I need to scroll the page
    }
    yourFunction();
  }

  ngOnInit() {
    this.modal = document.getElementById('myModal');
  }

}
