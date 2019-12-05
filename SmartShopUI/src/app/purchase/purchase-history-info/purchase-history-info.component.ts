import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { purchaseHistory } from '../purchaseHistory';
import { UserService } from 'src/app/register/user.service';

@Component({
  selector: 'app-purchase-history-info',
  templateUrl: './purchase-history-info.component.html',
  styleUrls: ['./purchase-history-info.component.css']
})
export class PurchaseHistoryInfoComponent implements OnInit {
 
  @Input() purchaseHistory:purchaseHistory;
  @Output() productId: EventEmitter<string> = new EventEmitter<string>();
  user: String;
constructor(private userService: UserService) { }

ngOnInit() {
  this.user = this.userService.user;
}

}
