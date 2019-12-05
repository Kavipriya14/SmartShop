import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ProductServiceService } from '../product-service.service';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {
  products:Product;
  editForm: FormGroup;
  productupdated:boolean=false;
  constructor(private productService:ProductServiceService) { }

  ngOnInit() {
    this.editForm = new FormGroup({
      'productCode':new FormControl(null,[Validators.required]),
      'productName': new FormControl(null, [Validators.required, Validators.maxLength(200)]),
      'image': new FormControl(null, [Validators.required]),
      'rate': new FormControl(null, [Validators.required, Validators.pattern('^[0-9]+$')]),
      'stock': new FormControl(null, [Validators.required, Validators.pattern('^[0-9]+$')]),
      'productType': new FormControl(null, Validators.required),
      'expiryDate': new FormControl(null,[Validators.required]),
      'manufactureDate': new FormControl(null,[Validators.required]),
      'date': new FormControl(null,[Validators.required]),
      'brand': new FormControl(null,[Validators.required]),
      'aisle': new FormControl(null, Validators.required),
      'shelf': new FormControl(null, Validators.required),
    });
  }
  onSubmitForm(){
    console.log(this.editForm.value);
    this.productupdated=true;
    this.productService.addProductDetails(this.editForm.value).subscribe((data)=>{
      console.log(data);
    })
  }
}
