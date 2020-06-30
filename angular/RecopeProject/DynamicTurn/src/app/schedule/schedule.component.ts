import { Component, OnInit } from '@angular/core';
import { ScheduleModule, DayService, WeekService, WorkWeekService, MonthService, AgendaService, MonthAgendaService, TimelineViewsService, TimelineMonthService, EventSettingsModel, ActionEventArgs, ToolbarActionArgs, ExportOptions, ExcelExportService, ResizeService, ICalendarExportService, ICalendarImportService, DragAndDropService } from '@syncfusion/ej2-angular-schedule';
import { MeetingsService } from '../service/meetings.service';
import { initChangeDetectorIfExisting } from '@angular/core/src/render3/instructions';
import { Meeting } from '../classes/meeting';
import { SelectedEventArgs } from '@syncfusion/ej2-inputs';
import { ALTERNATE_CELLS_CLASS } from '@syncfusion/ej2-schedule/src/schedule/base/css-constant';
import { GetUsersService } from '../service/get-users.service';
import { DestinationsService } from '../service/destinations.service';
import { delay } from 'q';
import { thisExpression } from 'babel-types';


@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css'],
  providers: [DayService, WeekService, WorkWeekService, MonthService, AgendaService, ResizeService,
    ICalendarExportService, ICalendarImportService, DragAndDropService],
})
export class ScheduleComponent {
  constructor(private meetingService: MeetingsService, private usersService: GetUsersService, private destService: DestinationsService) { }
  public scheduleObj: ScheduleComponent;
  public data: Meeting[] = [];
  public eventSettings: EventSettingsModel;
  public selectedDate: Date;
  ele: any;

  private init() {
    this.meetingService.getMeetingsByDestId().subscribe(state => {
      console.log('meetingService state: ' + state);
      this.data = state;
      this.eventSettings = {
        dataSource: this.data,
        fields: {
          id: 'id',
          subject: { name: 'subject' },
          isAllDay: { name: 'isAllDay' },
          startTime: { name: 'startTime' },
          endTime: { name: 'endTime' },
        }
      };
      this.selectedDate = new Date(2019, 9, 23);
    });
  }


  ngOnInit() {
    this.init();
    this.ele = document.getElementsByClassName('e-btn').item(11);
    // this.ele.addEventListener("click",this.change);
    //this.ele.onclick = this.change;


  }

  change() {
   // alert("im in onclick");
    this.data = this.eventSettings.dataSource as Meeting[];

    console.log(this.eventSettings.dataSource);

    if (document.getElementsByClassName('e-btn').item(11) != null) {
      if (this.data[this.data.length - 1].destId == null) {
        this.data[this.data.length - 1].startTime = null;
        this.data[this.data.length - 1].endTime = null;
        this.data[this.data.length - 1].destId = this.destService.destinationChoosen;
        this.data[this.data.length - 1].customerId = this.usersService.user.id;
        this.meetingService.saveMeetings(this.data).subscribe(item => {
          if (item.isTrue == true)
            console.log('is saved');
        });
      }
    }
  }


}
