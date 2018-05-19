import { Component, OnInit, ViewChild } from '@angular/core';
import { MessageService } from './message.service';
import { Message } from './message';
import { MatTableDataSource, MatPaginator } from '@angular/material';

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

  constructor(private messageService: MessageService) { }

  ngOnInit() {
    this.loadMessages();
  }

  onSelect(message: Message) {
    this.selectedMessage = message;
    console.log(this.selectedMessage.titre);
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
