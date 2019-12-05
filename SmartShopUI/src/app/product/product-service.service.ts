import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Product } from './product';
import { environment } from 'src/environments/environment';
import { UserService } from '../register/user.service';



@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {


  private subject=new Subject<Product[]>();
  filter = new Subject();
  constructor(private httpclient:HttpClient,private userService:UserService) { }

  getProducts():Observable<any>{
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.userService.getToken()); 
      return this.httpclient.get<Product[]>(environment.baseUrl+"smart-shop/product",{headers});
  }
  getSubject():Subject<Product[]>{
    return this.subject;
  }
  getByProductId(productid:string ):Observable<any>{
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.userService.getToken()); 
    return this.httpclient.get<Product>(environment.baseUrl+"smart-shop/product/"+productid,{headers});
  }
  modifyItem(product:Product):Observable<any>{
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.userService.getToken()); 
    return this.httpclient.put<Product>(environment.baseUrl+'smart-shop/product/modify',product,{headers});
    }
    addProductDetails(product:Product):Observable<any>{
      let headers = new HttpHeaders();
      headers = headers.set('Authorization', 'Bearer ' + this.userService.getToken()); 
      return this.httpclient.post<Product>(environment.baseUrl+"smart-shop/product/add",product,{headers})
    }

    getProductTypes(): Observable<any> {
      if (this.userService.getToken()) {
        let headers = new HttpHeaders();
        headers = headers.set('Authorization', 'Bearer ' + this.userService.getToken());
        return this.httpclient.get<String[]>(`${environment.baseUrl}` + 'smart-shop/product/type', { headers });
      }
    }
  
    getProductByType(productType: String): Observable<any> {
      if (this.userService.getToken()) {
        let headers = new HttpHeaders();
        headers = headers.set('Authorization', 'Bearer ' + this.userService.getToken());
        return this.httpclient.get<Product[]>(`${environment.baseUrl}` + 'smart-shop/product/type/' + productType, { headers });
      }
    }

  
}
