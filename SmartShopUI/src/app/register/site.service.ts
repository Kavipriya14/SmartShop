import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserService } from './user.service';
import { Observable } from 'rxjs';
import { User } from './user';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SiteService {

  constructor(private httpclient:HttpClient,private userService:UserService) { }

  getPendingManagers():Observable<any>{
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.userService.getToken()); 
    return this.httpclient.get<User[]>(environment.baseUrl+"smart-shop/superuser/",{headers});
  }
  superUserResponse(userid:string,status:string){
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.userService.getToken()); 
    return this.httpclient.put<User>(environment.baseUrl+"smart-shop/superuser/"+userid+"/"+status,null,{headers});
  }
}
