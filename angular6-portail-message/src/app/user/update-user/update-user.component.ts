import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  constructor(private route: ActivatedRoute,
    private location: Location,
    private userService: UserService) { }

  ngOnInit() {
  this.getUser();
  }


  @Input() user: User;
  submitted = false;
  valid = true;
  error = false;  
  private id : number;
  functions = [
    'Administrateur',
    'Agent'
  ]

  

  getUser(): void {
    this.id = + this.route.snapshot.paramMap.get('id');
    console.log('update-user.component::get User  with id=' + this.id + ' called');
    this.userService.getOneById(this.id)
      .subscribe(user => this.user = user);
  }

  updateUser(): void {
    console.log('update-user.component::update User with id=' + this.id);
    this.userService.update(this.id, this.user).subscribe(() => this.goBack());
  }

  goBack(): void {
    console.log('update-user.component::goBack');
    this.submitted = true;
  }
}