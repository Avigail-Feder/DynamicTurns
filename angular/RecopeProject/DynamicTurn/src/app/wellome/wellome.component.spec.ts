import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WellomeComponent } from './wellome.component';

describe('WellomeComponent', () => {
  let component: WellomeComponent;
  let fixture: ComponentFixture<WellomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WellomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WellomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
