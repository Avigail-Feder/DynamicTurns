import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-try',
  templateUrl: './try.component.html',
  styleUrls: ['./try.component.css']
})
export class TryComponent implements OnInit {
  ngOnInit() {

  }

  title = 'Angular Form Validation Tutorial';
  angForm: FormGroup;
  flag: boolean;
  constructor(private fb: FormBuilder) {
    this.createForm();
  }
  createForm() {
    this.angForm = this.fb.group({
      name: ['', Validators.required]
    });
  }
  check() {
    if (this.angForm.status == 'VALID')
      this.flag = true;
    else this.flag = false;
    console.log(this.angForm.status + ' ' + this.flag)
  }
}
