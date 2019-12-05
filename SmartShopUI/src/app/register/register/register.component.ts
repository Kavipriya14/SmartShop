import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
 
  signupForm: FormGroup;
  userExists:boolean=false;
  formSubmitted = false;


  constructor(private userService:UserService,private router:Router) { }

  ngOnInit() {
   this.signupForm = new FormGroup({
      'userid': new FormControl(null, [Validators.required, Validators.maxLength(20)]),
      'firstname': new FormControl(null, [Validators.required, Validators.pattern('^[a-zA-Z]+$'), Validators.maxLength(50)]),
      'lastname': new FormControl(null, [Validators.required, Validators.pattern('^[a-zA-Z]+$'), Validators.maxLength(50)]),
      'password': new FormControl(null, [Validators.required]),
      'confirmpassword': new FormControl(null, [Validators.required, this.matchConfirmPassword.bind(this)]),
      'userType': new FormControl(null, [Validators.required, Validators.maxLength(20)]),
      'gender': new FormControl(null, [Validators.required, Validators.maxLength(20)]),
      'age': new FormControl(null, [Validators.required]),
      'secretQuestion': new FormControl(null, [Validators.required, Validators.maxLength(20)]),
      'contact': new FormControl(null, [Validators.required,Validators.min(1000000000), Validators.max(999999999999)]),
      'answer': new FormControl(null, [Validators.required, Validators.maxLength(20)]),     
    });
  }
 
  matchConfirmPassword(formControl: FormControl): { [s: string]: boolean } {
    if (this.signupForm) {
      if (formControl.value && formControl.value.length > 0 && formControl.value !== this.signupForm.get('password').value) {
        return { 'nomatch': true };
      }
    }
    return null;
  }
  onSubmitSignUp() {
    
    this.formSubmitted = true;
    setTimeout(() => {
      this.formSubmitted = false;
    }, 1000);    
    this.router.navigate(['login']);

    console.log(this.signupForm.value);
    this.userService.signUp(this.signupForm.value).subscribe((data)=>{
      this.userExists=data;
    });
    this.signupForm.reset();
  }

}
