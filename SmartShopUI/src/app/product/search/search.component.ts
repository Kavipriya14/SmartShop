import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductServiceService } from '../product-service.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  searchkey: string;
  filteredList: Product[];
  originalLists: Product[];
  constructor(private productService: ProductServiceService) { }

  ngOnInit() {
    this.productService.getProducts().subscribe((data) => {
      this.originalLists = data;
    });
    this.filteredList = this.originalLists;
  }
  search(event: any) {
    this.filteredList = this.originalLists.filter(product => product.productName.toLocaleLowerCase().includes(this.searchkey.toLocaleLowerCase()));
    this.productService.getSubject().next(this.filteredList);
  }


}
