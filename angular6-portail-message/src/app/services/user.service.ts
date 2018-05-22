import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  private userForm = new User;
  private userUrl = 'http://localhost:8080/user'

  public getAll(): Observable<User[]> {
    console.log("user.service::getAll called");
    const response = this.http.get<User[]>(this.userUrl);
    console.log('user.service::getAll done');
    return response;
  }

  public getOneById(id: number): Observable<User> {
    console.log("user.service::getOne with id=" + id + " called");
    const url = `${this.userUrl}/id/${id}`;
    const response = this.http.get<User>(url);
    console.log("user.service::getOne with id=" + id + " done");
    return response;
  }

  public getOneByMatricule(matricule: String): Observable<User> {
    console.log("user.service::getOne with matricule=" + matricule + " called");
    const url = `${this.userUrl}/matricule/${matricule}`;
    const response = this.http.get<User>(url);
    console.log("user.service::getOne with matricule=" + matricule + " done");
    return response;
  }

  public checkLogin(userForm: User): Observable<User> {
    console.log('user.service::checkLogin matricule/password with matricule=' + userForm.matricule + " called");
    const response = this.http.post<User>(`${this.userUrl}/check`, userForm);
    console.log('user.service::checkLogin matricule/password with matricule=' + userForm.matricule + " done");
    return response;
  }

  public create(userForm: User): Observable<User> {
    console.log('user.service::create called');
    const result = this.http.post<User>(this.userUrl, this.userForm, httpOptions);
    console.log('user.service::create done');
    return result;
  }

  public update(id: number, user : User): Observable<any>{
    console.log("user.service:::update User called");
    const url = this.userUrl + "/" + id;
    const result =  this.http.put(url, user, httpOptions);  
    console.log("url : " + url);  
    console.log("user.service:::update User done");
    return result; 
    
  }

  public saveCurrentUserInSessionStorage(user: User): void {
    sessionStorage.setItem('currentUser', JSON.stringify(user));
  }

  public getCurrentUserFromSessionStorage(): User {
    return JSON.parse(sessionStorage.getItem('currentUser'));
  } 
  
  public removeCurrentUserFromSessionStorage(): void {
    sessionStorage.removeItem('currentUser');
  }
}
