import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UserService } from '../register/user.service';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { purchase } from '../purchase/purchase';
import { User } from '../register/user';


 
@Injectable({
  providedIn: 'root'
})
export class PurchaseService {

  constructor(private httpclient:HttpClient,private userService:UserService) { }

  
  getPurchase(): Observable<any> {
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.userService.getToken());
    return this.httpclient.get<number>(environment.baseUrl + "smart-shop/purchase", { headers })
  }

  postPurchase(purchase:purchase): Observable<any> {
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.userService.getToken());
    return this.httpclient.post(environment.baseUrl + "smart-shop/purchase", purchase,{ headers })
  }

  updatePurchaseHistory(purchaseId:number, productCode:String, quantity: number): Observable<any> {
    let headers = new HttpHeaders();
    console.log("entering purchaese");
    headers = headers.set('Authorization', 'Bearer ' + this.userService.getToken());
    console.log(headers);
    return this.httpclient.post(environment.baseUrl + "smart-shop/"+purchaseId+"/"+productCode+"/"+quantity,null,{headers});
  }

  getUser(userId:String): Observable<any> {
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.userService.getToken());
    return this.httpclient.get<User>(environment.baseUrl + "authentication/users/"+userId,{ headers })
  }

  updatePurchase(purchase:purchase): Observable<any> {
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.userService.getToken());
    return this.httpclient.put(environment.baseUrl + "smart-shop/purchase/", purchase,{ headers })
  }
}
