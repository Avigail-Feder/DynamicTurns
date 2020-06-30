import { Directive, ElementRef } from '@angular/core';
import { OnInit } from '@angular/core';

@Directive({
  selector: '[appValidation]'
})
export class ValidationDirective {

  constructor(private el:ElementRef) { }
  ngOnInit(){
    this.el.nativeElement.style.backgroundColor = 'red';
  }
}
