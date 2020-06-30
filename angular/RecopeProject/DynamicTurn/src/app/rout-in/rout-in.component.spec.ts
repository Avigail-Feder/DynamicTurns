import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RoutInComponent } from './rout-in.component';

describe('RoutInComponent', () => {
  let component: RoutInComponent;
  let fixture: ComponentFixture<RoutInComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RoutInComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RoutInComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
