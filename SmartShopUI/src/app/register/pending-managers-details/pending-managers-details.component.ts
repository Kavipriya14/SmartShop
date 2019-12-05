import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { SiteService } from '../site.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pending-managers-details',
  templateUrl: './pending-managers-details.component.html',
  styleUrls: ['./pending-managers-details.component.css']
})
export class PendingManagersDetailsComponent implements OnInit {
  users:User[]
  constructor(private siteService:SiteService,private router: Router) { }
  pendingDetails:boolean=false;
  ngOnInit() {
    this.getPendingManagers();
  }
    approve(userId:string){
        this.siteService.superUserResponse(userId,"A").subscribe((data)=>{
          console.log(data);
          this.getPendingManagers();
        });
       
    }
    deny(userId:string){
      this.siteService.superUserResponse(userId,"D").subscribe((data)=>{
        console.log(data);
        this.getPendingManagers();
      });
    }
    getPendingManagers(){
      this.siteService.getPendingManagers().subscribe((data)=>{
        this.users=data;
        console.log(this.users);
        if(this.users.length==0){
          this.pendingDetails=false;
        }else{
          this.pendingDetails=true;
        }
      });
    }
}
