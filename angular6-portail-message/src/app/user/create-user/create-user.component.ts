import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  private user = new User;
  private submitted = false;
  private valid = true;
  private error = false;

  private functions = [
    'Admnistrateur',
    'Agent'
  ]

  constructor(private userService: UserService) {
    console.log("create-user.component::constructor");
  }

  ngOnInit() {
  }

  public createUser(): void {
    this.formValidation();
    if (this.valid) {
      console.log("create-user.component::save");
      //this.userService.createUser(this.user).subscribe();
      this.userService.create(this.user).subscribe(
        (response) => {
          this.submitted = true;
          console.log("create-user.component.ts::save response = " + response);
        },
        (error) => {
          this.error = true;
          console.log("create-user.component.ts::save error = " + JSON.stringify(error));
        },
        function () { console.log("create-user.component.ts::save is completed "); }
      );
    }
  }

  private formValidation(): void {
    if (  
        this.user.matricule == null ||
        this.user.firstName == null ||
        this.user.lastName == null ||
        this.user.function == null  ) {
          this.valid = false;
          console.log( 'this.user.matricule = ' + this.user.matricule);
          console.log( 'this.user.firstname = ' + this.user.firstName);
          console.log( 'this.user.lastname = ' + this.user.lastName);
          console.log( 'this.user.function = ' + this.user.function);
        } else {
          console.log( 'this.user.matricule = ' + this.user.matricule);
          console.log( 'this.user.firstname = ' + this.user.firstName);
          console.log( 'this.user.lastname = ' + this.user.lastName);
          console.log( 'this.user.function = ' + this.user.function);
          this.valid = true;
          this.user.matricule.toLocaleLowerCase();
          this.user.password = this.user.matricule + 'mdp';
        }
  }
}
