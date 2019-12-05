import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  isLoginValid = true;
  isPending:boolean= false;
  superUser=false;
  
  constructor(private userService:UserService,private router: Router) { }


  ngOnInit() {
  }
  onSubmit(form: NgForm){
    const username = form.value.username;
    const password = form.value.password;
    console.log(username+"  "+password);
    this.isPending = false;
    this.isLoginValid = true;
    this.userService.authenticate(username,password).subscribe((data)=>{
       console.log(data);
     
      this.userService.setToken(data.Token);
      if(data.Token==null){
        this.isPending = true;
        this.userService.loggedIn = false;
        console.log("Not LoggedIn")
      }else{
      console.log(data.Token);
      console.log("loggedIn");
      if(data.Role=='S'){
        this.superUser=true
        this.userService.isSuperUser(this.superUser);
      }
      if(data.Role=='A'){
        this.userService.managerUser=true;
     
      }
      this.router.navigate(['productdetails']);
      }
     
    },(error)=>{
      this.isLoginValid = false;
    });
  }

}

