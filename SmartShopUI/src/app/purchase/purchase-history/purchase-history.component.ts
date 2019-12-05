import { Component, OnInit } from '@angular/core';
import { purchaseHistory } from '../purchaseHistory';
import { PurchaseHistoryService } from '../purchase-history.service';
import { UserService } from 'src/app/register/user.service';

@Component({
  selector: 'app-purchase-history',
  templateUrl: './purchase-history.component.html',
  styleUrls: ['./purchase-history.component.css']
})
export class PurchaseHistoryComponent implements OnInit {
  purchaseHistory: purchaseHistory[];
  user: String;
  constructor(private purchaseService: PurchaseHistoryService, private userService: UserService) { }

  ngOnInit() {
    this.user = this.userService.user;
    this.purchaseService.getPurchaseHistory(this.user).subscribe((data) => {
      this.purchaseHistory = data;
      console.log(data);
    })
  }

}
