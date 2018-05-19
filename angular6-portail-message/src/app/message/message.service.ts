import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Message } from './message';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class MessageService {

  constructor(private http: HttpClient) { }

  private messageUrl = 'http://localhost:8080/message'

   public getAll(): Observable<Message[]> {
    console.log("message.service::getAll");
    return this.http.get<Message[]>(this.messageUrl);
  }
  
  public getOneById(id: number): Observable<Message> {
    console.log("message.service::get Message with id=" + id);
    const url = `${this.messageUrl}/${id}`;
    return this.http.get<Message>(url);
  }

  public delete(id: number): Observable<Message> {
    console.log("message.service::get Message with id=" + id);
    const url = `${this.messageUrl}/${id}`;
    return this.http.delete<Message>(url);
  }
}