import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/product/product';
import { purchase } from 'src/app/purchase/purchase';
import { User } from 'src/app/register/user';
import { FormGroup, NgForm } from '@angular/forms';
import { ProductServiceService } from 'src/app/product/product-service.service';
import { PurchaseService } from '../purchase.service';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.css']
})
export class BillComponent implements OnInit {
  products: Array<Product> = [];
  product: Product
  productName: String = null;
  type: string
  productCode: String
  quantity: number;
  producttype: String;
  productTypes: Array<String> = [];
  productNames: Array<String> = []
  i: number;
  quan: number;
  total: number = 0;
  billTotal: number = 0
  nonavailability: boolean = true
  purchasedData = [
    {
      type: null,
      name: null,
      code: null,
      quan: 0,
      total: 0
    }
  ]
  isPurchasedData = false;
  purchaseId: number;
  purchase: purchase;
  purchaseForm: FormGroup;
  userId: String;
  user: User;
  date: Date;

  constructor(private productService: ProductServiceService,private purchaseService:PurchaseService) {

  }
  ngOnInit() {
    this.productService.getProducts().subscribe((data) => {
      this.products = data;
      console.log(this.products);
    });
    this.productService.getProductTypes().subscribe((data) => {
      this.productTypes = data;
      console.log(this.productTypes);
    });
    this.purchaseService.getPurchase().subscribe((data) => {
      console.log(data);
      this.purchaseId = data + 1;
  
    })
  }
  getproductNames(productType) {
    this.producttype = productType.target.value;
    console.log(this.producttype);
    this.productNames = []
    for (this.product of this.products) {
      if (this.product.productType == productType.target.value && this.product.stock>0) {
        this.productNames.push(this.product.productName);
      }
    }
    console.log(this.productNames.length);
  }
  getproductName(prodName) {
    console.log(prodName.target.value);
    this.productName = prodName.target.value;
    for (this.product of this.products) {
      if (this.product.productName == this.productName) {
        this.productCode = this.product.productCode;
      }
    }
  }
  amountupdate(event: any) {
    console.log(this.quantity);
    for (this.product of this.products) {
      if (this.product.productName == this.productName) {
        this.total = this.product.rate * this.quantity;
      }
    }
    console.log(this.total);
  }
  add() {
    if (this.purchasedData[0].quan == 0) {
      this.nonavailability = false;
      this.isPurchasedData = true;
      this.purchasedData = [{ type: this.producttype, name: this.productName, code: this.productCode, quan: this.quantity, total: this.total }];
    } else {
      this.purchasedData.push({ type: this.producttype, name: this.productName, code: this.productCode, quan: this.quantity, total: this.total });
    }
    this.purchaseService.updatePurchaseHistory(this.purchaseId, this.productCode, this.quantity).subscribe((data) => {
      console.log(data);
    })
    this.billTotal = this.billTotal + this.total;
    //this.producttype = null;
    // this.productName = null;
    this.productCode = null;
    this.quantity = 0;
    this.total = 0;
    console.log(this.purchasedData);
  }
  onSubmitForm(form: NgForm) {
    this.userId = form.value.userId;
    this.purchaseId = form.value.purchaseId;
    this.date = form.value.date;
    let pur: purchase = {} as any;
    this.purchaseService.getUser(this.userId).subscribe((data) => {
      this.user = data;
      console.log(data);
      pur.id = form.value.purchaseId;
      pur.date = form.value.date;
      pur.user = this.user;
      console.log(pur);
      this.purchaseService.postPurchase(pur).subscribe((data) => {
        console.log(data);
      })
    })

  }

  submitBill(){
    let pur: purchase = {} as any;
      pur.id = this.purchaseId;
      pur.date = this.date;
      pur.user = this.user;
      pur.totalAmount = this.billTotal; 
      console.log(pur);
      this.purchaseService.updatePurchase(pur).subscribe((data) => {
        console.log(data);
      })
  }
}
