import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from './register/user.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'smartshop';
  constructor(private userService:UserService,private router: Router){

  }

  isSuperUser(){
    return this.userService.superUser;
  }
  isLoggedIn(){
    return this.userService.loggedIn;
  }
  onSignOut() {

    this.userService.logout();
    this.router.navigate([environment.baseUrl]);
  }
  getUser(){
    return this.userService.user;
  }
  isShopManager(){
    return this.userService.managerUser;
  }

}

