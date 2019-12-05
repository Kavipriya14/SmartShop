import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  superUser=false;
  private token: string;
  user:String;
  loggedIn:boolean=false;
  managerUser: boolean=false;
  public setToken(token: string) {
    this.token = token;
  }
  public getToken() {
    return this.token; 
  }
  constructor(private httpClient:HttpClient) { }
  authenticate(username: string, password: string): Observable<any> {
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Basic ' +btoa(username + ':' + password));
    this.loggedIn=true;
    this.user=username;
    return this.httpClient.get(environment.baseUrl+'authentication/authenticate', {headers})
  }
  isSuperUser(isSuperUser:boolean){
      this.superUser=isSuperUser;
  }
  signUp(user:User):Observable<any>{
    return this.httpClient.post<User>(environment.baseUrl+'authentication/users',user);
  }
  logout(){
    this.loggedIn=false;
    this.token=null;
  }
}
