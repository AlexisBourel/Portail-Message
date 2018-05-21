import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs';
import { Tour } from '../models/tour';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class TourService {

  constructor(private http: HttpClient) { }

  private tourUrl = 'http://localhost:8080/tour'

   public getAll(): Observable<Tour[]> {
    console.log("tour.service::getAllTour");
    return this.http.get<Tour[]>(this.tourUrl);
  }
  
  public getOneById(id: number): Observable<Tour> {
    console.log("tour.service::getTour with id=" + id);
    const url = `${this.tourUrl}/${id}`;
    return this.http.get<Tour>(url);
  }
}