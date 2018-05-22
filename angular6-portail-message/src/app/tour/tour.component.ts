import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm, FormGroup, FormBuilder } from '@angular/forms';
import { Tour } from '../models/tour';
import { TourService } from '../services/tour.service';
import { MatTableDataSource, MatPaginator } from '@angular/material';
import { Router } from '@angular/router';



@Component({
  selector: 'app-tour',
  templateUrl: './tour.component.html',
  styleUrls: ['./tour.component.css']
})
export class TourComponent implements OnInit {
  
  private dataSource = new MatTableDataSource();
  private displayedColumns = ['name'];
  private tours: Tour[];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  selectedTour: Tour;

  constructor(private tourService: TourService, private router: Router) { }

  ngOnInit() {
    this.getTours();
  }

  private getTours(): void {
    this.tourService.getAll().subscribe(
      data => {
      this.dataSource = new MatTableDataSource(data);
        this.dataSource.paginator = this.paginator;
        console.log(data);
        console.log("tours loaded");
      }
    );
  }

  refresh(): void {    
    this.getTours();
    console.log('data refresh');
  }

  onSelect(tour: Tour) {
    this.selectedTour = tour;
    console.log(this.selectedTour.name);
    console.log('navigate to tournée with id : ' + this.selectedTour.id);
    this.router.navigate(["tournee/" + this.selectedTour.id]);
  }

}
