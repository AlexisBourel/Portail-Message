import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { User } from '../models/user';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { MessageService } from '../services/message.service';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {

  constructor(private userService: UserService, private messageService : MessageService) { }

  currentUser: User;
  dataImported = false;

  ngOnInit() {
    this.currentUser = this.userService.getCurrentUserFromSessionStorage();
  }

  public importData(): void {
    console.log("Data import called");
    this.messageService.getAll();
    console.log("Data import done");
    this.dataImported = true;
  }

}
