import { Component, OnInit } from '@angular/core';
import { UserService } from '../user/user.service';
import { Location } from '@angular/common';
import { User } from '../user/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

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
            console.log('userDb fonction : ' + this.userDb.function);
            if (this.userDb.function === "Administrateur") {              
              this.goToSupervision();
            } else {
              this.goToSelectTours();
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
    this.router.navigate(['/supervision']);
  };

  goToSelectTours(){
    console.log('Administrateur  non détécté');
    console.log('redirect to Tour Selection');
    this.router.navigate(['/select-tour']);
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
