import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatPaginator } from '@angular/material';
import { Message } from '../../models/message';
import { MessageService } from '../../services/message.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-tour-message',
  templateUrl: './tour-message.component.html',
  styleUrls: ['./tour-message.component.css']
})
export class TourMessageComponent implements OnInit {

  dataSource = new MatTableDataSource();
  @ViewChild(MatPaginator) paginator: MatPaginator;
  messages: Message[];
  selectedMessage: Message;
  private id: number;
  displayedColumns = ['createdAt', 'type', 'title'];

  constructor(private messageService: MessageService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getAllMessageTour()
  }

  private getAllMessageTour() {
    this.id = + this.route.snapshot.paramMap.get('id');
    this.messageService.getAllTourMessages(this.id).subscribe(
      data => {
      this.dataSource = new MatTableDataSource(data);
        this.dataSource.paginator = this.paginator;
        console.log(data);
        console.log("message loaded");
      }
    );
  }
}


