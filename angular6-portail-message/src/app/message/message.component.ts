import { Component, OnInit, ViewChild } from '@angular/core';
import { MessageService } from './message.service';
import { Message } from './message';
import { MatTableDataSource, MatPaginator } from '@angular/material';
import { Location } from '@angular/common';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {

  dataSource = new MatTableDataSource();
  @ViewChild(MatPaginator) paginator: MatPaginator;
  messages: Message[];
  selectedMessage: Message;

  displayedColumns = ['createdAt', 'tour.name','type','title', 'edit', 'delete'];

  constructor(private messageService: MessageService, private location: Location) { }

  ngOnInit() {
    this.loadMessages();
  }

  goBack() {
    console.log('message component go back');
    this.location.back();
  }

  onDelete(id:number) {
    this.messageService.delete(id).subscribe(
      () => this.loadMessages()
    );
  }

  refresh(): void {    
    this.getMessages();
    console.log('data refresh');
  }

  getMessages(){
    this.messageService.getAll()
        .subscribe(messages => this.messages = messages);
  };

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
   this.dataSource.filter = filterValue;
  }

  loadMessages(){
    this.messageService.getAll().subscribe(
      data => { this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
      console.log(data);
      console.log("affaires loaded");
     }
    );
  }

}
