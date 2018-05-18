import { Component, OnInit } from '@angular/core';
import { NgForm, FormGroup, FormBuilder } from '@angular/forms';

import { TourneeService } from './tournee.service';
import { Tournee } from './tournee';

@Component({
  selector: 'app-tournee',
  templateUrl: './tournee.component.html',
  styleUrls: ['./tournee.component.css']
})
export class TourneeComponent implements OnInit {
  
  tournees: Tournee[];

  selectedTournee: Tournee;

  
  constructor(private tourneeService: TourneeService) { }

  ngOnInit() {
    this.getTournees();
  }

  onSubmit() {

    console.log(this.selectedTournee)
    
  }

  getTournees(): void {
    this.tourneeService.getAll()
        .subscribe(tournees => this.tournees = tournees);
  }

  refresh(): void {
    
    this.getTournees();
    console.log('data refresh');
  }

}
