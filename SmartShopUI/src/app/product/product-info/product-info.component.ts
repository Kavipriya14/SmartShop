import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Product } from '../product';
import { UserService } from 'src/app/register/user.service';


@Component({
  selector: 'app-product-info',
  templateUrl: './product-info.component.html',
  styleUrls: ['./product-info.component.css']
})
export class ProductInfoComponent implements OnInit {
  isManagerUser:boolean=false;
  @Input() product:Product;
  @Output() productId: EventEmitter<string> = new EventEmitter<string>();
constructor(private userService:UserService) { }

ngOnInit() {
 this.isManagerUser=this.userService.managerUser;
}

}

