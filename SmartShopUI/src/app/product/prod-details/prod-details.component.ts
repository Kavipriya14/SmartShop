import { Component, OnInit } from '@angular/core';
import { ProductServiceService } from '../product-service.service';
import { Product } from '../product';

@Component({
  selector: 'app-prod-details',
  templateUrl: './prod-details.component.html',
  styleUrls: ['./prod-details.component.css']
})
export class ProdDetailsComponent implements OnInit {
  allProducts: Product[];
  originalList: Product[];
 

  constructor(private productservice:ProductServiceService) { }

  ngOnInit() {
    this.getProducts();
    this.productservice.getSubject().subscribe((data)=>{
      this.originalList = [...data]; 
      this.allProducts=[...data];
    });
    this.productservice.filter.subscribe((obj: { name: string })=>{
      if (obj.name !== '') { // filter from original list for search text, and update list rendered
        const result = this.originalList.filter(prod => prod.productName.toLowerCase().includes(obj.name.toLowerCase()));
        this.allProducts = result ? result : [];
      } else { // reset to original product list, if not search text entered
        this.allProducts = [...this.originalList];
      }
    });
  }

 getProducts(){
    this.productservice.getProducts().subscribe((data)=>{
      this.allProducts=data;
    });
  }

  sort(sortkey){
    console.log(sortkey.target.value);
    if(sortkey.target.value=="name"){
      this.allProducts=this.allProducts.sort((productA:Product,productB:Product):number=>{
        if(productA.productName>productB.productName) return +1;
        if(productA.productName<productB.productName) return -1;
      })
    }
    else if(sortkey.target.value=="price"){
      this.allProducts=this.allProducts.sort((productA:Product,productB:Product):number=>{
        if(productA.rate>productB.rate) return +1;
        if(productA.rate<productB.rate) return -1;
      })
    }else if(sortkey.target.value=="availability"){
      this.allProducts=this.allProducts.sort((productA:Product,productB:Product):number=>{
        if(productA.stock>productB.stock) return +1;
        if(productA.stock<productB.stock) return -1;
      })
    }
  }
  

}
