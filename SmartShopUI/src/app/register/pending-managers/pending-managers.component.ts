import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { User } from '../user';
import { SiteService } from '../site.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pending-managers',
  templateUrl: './pending-managers.component.html',
  styleUrls: ['./pending-managers.component.css']
})
export class PendingManagersComponent implements OnInit {

  @Input() userinput:User;
  @Output() userId: EventEmitter<string> = new EventEmitter<string>();
  @Output() userIddeny: EventEmitter<string> = new EventEmitter<string>();
  constructor(private siteService:SiteService,private router:Router) { }
  pendingUser:User[];
  ngOnInit() {
      this.siteService.getPendingManagers().subscribe((data)=>{
        this.pendingUser=data;
        console.log(data);
      }); 
  }
  approve(userIdhtml:string){
    this.userId.emit(userIdhtml);
  }
  deny(userIdhtml:string){
    this.userIddeny.emit(userIdhtml);
  }

  onSubmit(){
    this.router.navigate(['productdetails']);

  }
}
