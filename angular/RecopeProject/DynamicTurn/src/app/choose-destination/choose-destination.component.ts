import { Component, OnInit } from '@angular/core';
import { DestinationsService } from '../service/destinations.service';
import { Destination } from '../classes/destination';
import { Router } from '@angular/router';
@Component({
  selector: 'app-choose-destination',
  templateUrl: './choose-destination.component.html',
  styleUrls: ['./choose-destination.component.css']
})
export class ChooseDestinationComponent implements OnInit {

  constructor(private destinaionService: DestinationsService, private router: Router) { }
  destinations: Destination[];
  ngOnInit() {
    this.destinaionService.get().subscribe(item => this.destinations = item);
  }

  setDestination(id: string) {
    this.destinaionService.destinationChoosen = id;
    console.log(this.destinaionService.destinationChoosen);
    this.router.navigate(['/schedule']);
  }

}
