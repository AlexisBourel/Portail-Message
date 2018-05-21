import { Component, OnInit } from '@angular/core';
import { Message } from '../../models/message';
import { Tour } from '../../models/tour';
import { MessageService } from '../../services/message.service';
import { TourService } from '../../services/tour.service';

@Component({
  selector: 'app-create-message',
  templateUrl: './create-message.component.html',
  styleUrls: ['./create-message.component.css']
})
export class CreateMessageComponent implements OnInit {

  message = new Message;
  submitted = false;
  valid = true;
  error = false;
  tours: Tour[];

  types = [
    { value: 'Incident', viewValue: 'Incident' },
    { value: 'Travaux', viewValue: 'Travaux' },
    { value: 'Commande', viewValue: 'Commande' },
    { value: 'Fermeture', viewValue: 'Fermeture' },
    { value: 'Contact', viewValue: 'Contact' },
    { value: 'Autre', viewValue: 'Autre' },
  ]
  

  constructor(private messageService: MessageService, private tourService: TourService) {
    console.log("create-message.component::constructor");
  }

  ngOnInit() {
    this.getTours();
  }

  private save(): void {
    console.log("create-message.component::save");
    //this.messageService.createMessage(this.message).subscribe();
    this.messageService.create(this.message).subscribe(
      (response) => {
        this.submitted = true;
        console.log("create-message.component.ts::save response = " + response);
      },
      (error) => {
        this.error = true;
        console.log("create-message.component.ts::save error = " + JSON.stringify(error));
      },
      function () { console.log("create-message.component.ts::save is completed "); }
    );
  }


  createMessage() {
    this.validationFormulaire();
    if (this.valid) {
      console.log("create-message.component::createMessage");
      this.save();
    }
  }

  reload(): void {
    console.log("create-message.component::relaod");
    this.submitted = false;
    this.message = new Message;
  }

  getTours(): void {
    this.tourService.getAll()
        .subscribe(tours => this.tours = tours);
  }

  private validationFormulaire(): void {
    if (
      this.message.title == null ||
      this.message.content == null ||
      this.message.tour == null) {
      this.valid = false;

    } else {
      this.valid = true;
    }
  }
}
