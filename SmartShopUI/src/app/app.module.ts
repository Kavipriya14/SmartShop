import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{ ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './register/login/login.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { RegisterComponent } from './register/register/register.component';
import { ProdDetailsComponent } from './product/prod-details/prod-details.component';

import { UserService } from './register/user.service';
import { PendingManagersComponent } from './register/pending-managers/pending-managers.component';
import { PendingManagersDetailsComponent } from './register/pending-managers-details/pending-managers-details.component';
import { ProductInfoComponent } from './product/product-info/product-info.component';
import { SearchComponent } from './product/search/search.component';
import { ProductEditComponent } from './product/product-edit/product-edit.component';
import { ProductAddComponent } from './product/product-add/product-add.component';
import { PurchaseHistoryComponent } from './purchase/purchase-history/purchase-history.component';
import { PurchaseHistoryInfoComponent } from './purchase/purchase-history-info/purchase-history-info.component';

import { BillComponent } from './bill/bill/bill.component';
import { HomeComponent } from './home/home/home.component';
import { AboutComponent } from './home/about/about.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ProdDetailsComponent,
    PendingManagersComponent,
    PendingManagersDetailsComponent,
    ProductInfoComponent,
    SearchComponent,
    ProductEditComponent,
    ProductAddComponent,
    PurchaseHistoryComponent,
    PurchaseHistoryInfoComponent,
    BillComponent,
    HomeComponent,
    AboutComponent,

 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      {
        path:'',
        component: HomeComponent
      },
      {
        path:'login',
        component: LoginComponent
      },
      {
        path:'login/register',
        component: RegisterComponent
      },
      {
        path:'productdetails',
        component: ProdDetailsComponent
      },
     
      {
        path:'pendingdetails',
        component:PendingManagersDetailsComponent
      },
      {
        path:'editProduct/:id',
        component:ProductEditComponent
      },
      {
        path:'addProduct',
        component:ProductAddComponent,
      },
      {
        path:'billing',
        component:BillComponent
      },
      {
        path:'purchaseHistory',
        component:PurchaseHistoryComponent,
      },
      {
        path:'about',
        component: AboutComponent,
      }
    ])
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})

export class AppModule { }
