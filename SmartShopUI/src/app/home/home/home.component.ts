import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/register/user.service';
import { environment } from 'src/environments/environment';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  productupdated=false;
 

  constructor(private userService:UserService,private router: Router) { }

  ngOnInit() {
  }

  isLoggedIn(){
    return this.userService.loggedIn;
  }
  onSignOut() {

    this.userService.logout();
    this.router.navigate([environment.baseUrl]);
  }
}
