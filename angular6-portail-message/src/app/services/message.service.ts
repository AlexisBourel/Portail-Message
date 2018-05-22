import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


import { Observable } from 'rxjs';
import { Message } from '../models/message';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class MessageService {

  constructor(private http: HttpClient) { }

  private messageUrl = 'http://localhost:8080/message'

   public getAll(): Observable<Message[]> {
    console.log("message.service::getAll called");
    const result = this.http.get<Message[]>(this.messageUrl);
    console.log("message.service::getAll succes");
    return result;
  }

  getMessage(id: number): Observable<Message> {
    console.log("affaire.service::getAffaire with id=" + id);
    const url = `${this.messageUrl}/${id}`;
    return this.http.get<Message>(url);
  }

  getAllTourMessages(id: number): Observable<Message[]> {
    console.log("message.service::getAllTourMessages called");
    const result = this.http.get<Message[]>(this.messageUrl + "/tour/" + id);
    console.log("message.service::getAllTourMessages succes");
    return result;
  }
  
  public create(message: Message): Observable<Message>{
    console.log("message.service:::create Message called");
    message.autor = JSON.parse(sessionStorage.getItem('currentUser'));    
    const result =  this.http.post<Message>(this.messageUrl, message, httpOptions);
    console.log("message.service:::create Message succes");
    return result;
  }

  public update(id: number, message : Message): Observable<any>{
    console.log("message.service:::update Message called");
    message.updateBy = JSON.parse(sessionStorage.getItem('currentUser'));
    console.log("message.service:::update Message user set : " + message.updateBy.matricule);
    const url = this.messageUrl + "/" + id;
    const result =  this.http.put(url, message, httpOptions);  
    console.log("url : " + url);  
    console.log("message.service:::update Message done");
    return result; 
    
  }

  public delete(id: number): Observable<Message> {
    console.log("message.service::delete Message with id=" + id + " called");
    const url = this.messageUrl + "/" + id;
    const result = this.http.delete<Message>(url);
    console.log("message.service::delete Message with id=" + id + " succes");
    return result;
  }
}