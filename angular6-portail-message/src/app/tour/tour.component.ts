import { Component, OnInit } from '@angular/core';
import { NgForm, FormGroup, FormBuilder } from '@angular/forms';
import { Tour } from '../models/tour';
import { TourService } from '../services/tour.service';



@Component({
  selector: 'app-tour',
  templateUrl: './tour.component.html',
  styleUrls: ['./tour.component.css']
})
export class TourComponent implements OnInit {
  
  tours: Tour[];
  selectedTour: Tour;

  constructor(private tourService: TourService) { }

  ngOnInit() {
    this.getTours();
  }

  getTours(): void {
    this.tourService.getAll()
        .subscribe(tours => this.tours = tours);
  }

  refresh(): void {    
    this.getTours();
    console.log('data refresh');
  }

  onSelect(tour: Tour) {
    this.selectedTour = tour;
    console.log(this.selectedTour.name);
  }

}
