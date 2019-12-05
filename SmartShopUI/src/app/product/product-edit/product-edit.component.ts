import { Component, OnInit } from '@angular/core';
import { ProductServiceService } from '../product-service.service';
import { Product } from '../product';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  products:Product;
  editForm: FormGroup;
  productupdated:boolean=false;
  constructor(private productService:ProductServiceService, private route: ActivatedRoute) { }

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
    this.route.params.subscribe((params: Params) => {
      const prodId = params['id'];
       //console.log(prodId);
      this.productService.getByProductId(prodId).subscribe((product: Product) => {
         product.manufactureDate=new Date(product.manufactureDate);
       product.manufactureDate.setDate(product.manufactureDate.getDate()+1);
       product.expiryDate=new Date(product.expiryDate);
       product.expiryDate.setDate(product.expiryDate.getDate()+1);
       console.log(product.date);
       product.date=new Date(product.date);
       console.log(product.date);
      product.date.setDate(product.date.getDate()+1);
        console.log(product.date);
          this.editForm.patchValue({
            productCode:product.productCode,
            productName:product.productName,
            image:product.image,
            rate:product.rate,
            stock:product.stock,
            productType:product.productType,
            expiryDate:product.expiryDate.toISOString().substring(0,10),
            manufactureDate:product.manufactureDate.toISOString().substring(0,10),
            date:product.date.toISOString().substring(0,10),
            brand:product.brand,
            aisle:product.aisle,
            shelf:product.shelf
          });
      });
    });
  }
  onSubmitEditForm(){
    this.productService.modifyItem(this.editForm.value).subscribe(data=>{
      this.productupdated=true;
      console.log(this.productupdated)
      console.log(data);
    })
    
  }

}