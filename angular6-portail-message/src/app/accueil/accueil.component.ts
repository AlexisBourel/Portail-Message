import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { User } from '../models/user';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {

  constructor(private userService: UserService) { }

  currentUser: User;

  ngOnInit() {
    this.currentUser = this.userService.getCurrentUserFromSessionStorage();
  }

}
