import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserService } from '../register/user.service';
import { Observable } from 'rxjs';
import { purchaseHistory } from './purchaseHistory';
import { environment } from 'src/environments/environment';



@Injectable({
  providedIn: 'root'
})
export class PurchaseHistoryService {
  constructor(private httpClient: HttpClient, private userService: UserService) { }

  getPurchaseHistory(userId: String): Observable<any> {
    if (this.userService.getToken()) {
      let headers = new HttpHeaders();
      headers = headers.set('Authorization', 'Bearer ' + this.userService.getToken());
      return this.httpClient.get<purchaseHistory[]>(`${environment.baseUrl}` + 'smart-shop/purchase/history/' + userId, { headers });
    }
  }
}
