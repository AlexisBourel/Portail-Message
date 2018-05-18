import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


import { Tournee } from './tournee';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class TourneeService {

  constructor(private http: HttpClient) { }

  private tourneeUrl = 'http://localhost:8080/tournee'

   public getAll(): Observable<Tournee[]> {
    console.log("tournee.service::getAllTournee");
    return this.http.get<Tournee[]>(this.tourneeUrl);
  }
  
  public getOneById(id: number): Observable<Tournee> {
    console.log("tournee.service::getTournee with id=" + id);
    const url = `${this.tourneeUrl}/${id}`;
    return this.http.get<Tournee>(url);
  }
}