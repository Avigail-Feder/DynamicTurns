import { Component, OnInit } from '@angular/core';
import {  DayService, WeekService, WorkWeekService, MonthService, AgendaService, MonthAgendaService, TimelineViewsService, TimelineMonthService, EventSettingsModel } from '@syncfusion/ej2-angular-schedule';
import { MeetingsService } from '../service/meetings.service';
import { initChangeDetectorIfExisting } from '@angular/core/src/render3/instructions';
import { Meeting } from '../classes/meeting';
import { toUnicode } from 'punycode';
@Component({
  selector: 'app-all-schedule',
  templateUrl: './all-schedule.component.html',
  styleUrls: ['./all-schedule.component.css'],
  providers: [DayService, WeekService, WorkWeekService, MonthService, AgendaService, MonthAgendaService, TimelineViewsService, TimelineMonthService],
})
export class AllScheduleComponent implements OnInit {
  constructor(private meetingService: MeetingsService) { }
  public data: Meeting[];
  public eventSettings: EventSettingsModel;
  public selectedDate: Date;
  public scheduleObj: AllScheduleComponent;
  private init() {
    this.meetingService.getMeetings().subscribe(state => {
      this.data = state;
      this.eventSettings = {
        dataSource: this.data,
        fields: {
          id: 'id',
          subject: { name: 'subject' },
          isAllDay: { name: 'isAllDay' },
          startTime: { name: 'startTime' },
          endTime: { name: 'endTime' }
        }
      };
      this.selectedDate=new Date();
      console.log("the first data " + this.data[0].subject);
    }
    );
  }
  ngOnInit() {
    this.init();
  }

 

  
}
