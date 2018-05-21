import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Message } from '../../models/message';
import { Tour } from '../../models/tour';
import { MessageService } from '../../services/message.service';
import { TourService } from '../../services/tour.service';

@Component({
  selector: 'app-update-message',
  templateUrl: './update-message.component.html',
  styleUrls: ['./update-message.component.css']
})
export class UpdateMessageComponent implements OnInit {

  @Input() message : Message;
  submitted = false;
  valid = true;
  error = false;
  tours: Tour[];
  private id : number;
  types = [
    { value: 'Incident', viewValue: 'Incident' },
    { value: 'Travaux', viewValue: 'Travaux' },
    { value: 'Commande', viewValue: 'Commande' },
    { value: 'Fermeture', viewValue: 'Fermeture' },
    { value: 'Contact', viewValue: 'Contact' },
    { value: 'Autre', viewValue: 'Autre' },
  ]

  constructor(private messageService: MessageService,
              private tourService: TourService,
              private route: ActivatedRoute,
              private location: Location) { }

  ngOnInit() {
    this.getTours();
    this.getMessage();
  }

  getTours(): void {
    this.tourService.getAll()
        .subscribe(tours => this.tours = tours);
  }

  getMessage(): void {
    this.id = + this.route.snapshot.paramMap.get('id');
    console.log ( "this id : " + this.id);
    console.log('update-message.component::get Message  with id=' + this.id);
    this.messageService.getMessage(this.id)
      .subscribe(message => this.message = message);
  }

  updateMessage(): void {
    console.log('update-message.component::update Message with id=' + this.id);
    this.messageService.update(this.id, this.message).subscribe(() => this.goBack());
  }

  goBack(): void {
    console.log('update-message.component::goBack');
    this.submitted = true;
  }
}