import { Component, OnInit } from '@angular/core';
import { UserService } from '../user/user.service';
import { Location } from '@angular/common';
import { User } from '../user/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-authentification',
  templateUrl: './authentification.component.html',
  styleUrls: ['./authentification.component.css']
})
export class AuthentificationComponent implements OnInit {

  users: User[];
  userForm = new User;
  userDb = new User;
  valid = false;
  error = false;

  constructor(private userService: UserService, private location: Location, private router: Router) { }

  ngOnInit() {

  }

  onSignIn() {
    console.log('sign in');
    this.validationForm();
    console.log('valid : ' + this.valid);
    if (this.valid) {
      this.userService.checkLogin(this.userForm)
        .subscribe(
          (response) => {
            this.userDb = response;
            console.log('check succes ');
            console.log('userDb fonction : ' + this.userDb.fonction);
            if (this.userDb.fonction === "Administrateur") {              
              this.goToSupervision();
            } else {
              this.goToSelectTournees();
            }
          },
          (error) => {
            console.log('check fail');
            this.error = true;
          }
          
        );
    }
  }

  goToSupervision(){
    console.log('Administrateur détécté');
    console.log('redirect to supervision');
    this.router.navigate(['portail-message/supervision']);
  };

  goToSelectTournees(){
    console.log('Administrateur  non détécté');
    console.log('redirect to Tournee Selection');
    this.router.navigate(['portail-message/accueil']);
  }

  getUsers() {
    console.log('import des users');
    this.userService.getAll()
      .subscribe(users => this.users = users);
  }

  validationForm() {
    if (this.userForm.matricule == null ||
      this.userForm.password == null) {
      this.valid = false;
    } else {
      this.valid = true;
    }
  }



}