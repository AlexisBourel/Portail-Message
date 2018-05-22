import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatPaginator } from '@angular/material';
import { UserService } from '../../services/user.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.css']
})
export class ListUserComponent implements OnInit {

  private dataSource = new MatTableDataSource();
  private displayedColumns = ['matricule', 'firstname', 'lastname', 'function', 'phone', 'edit', 'delete'];
  private users: User[];
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.getUsers();
  }

  private getUsers(): void {
    this.userService.getAll().subscribe(
      data => {
      this.dataSource = new MatTableDataSource(data);
        this.dataSource.paginator = this.paginator;
        console.log(data);
        console.log("users loaded");
      }
    );
  }
}


