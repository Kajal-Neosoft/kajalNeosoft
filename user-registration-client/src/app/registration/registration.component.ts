import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserRegistrationService } from '../user-registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  // we are not goint to the hard code whatever value will come from form want to get this only
  user: User=new User("","",0,"");
  message:any

  constructor(private service:UserRegistrationService) { }

  ngOnInit(): void {
  }

  public registerNow()
  {
    let resp = this.service.doRegistration(this.user)
    resp.subscribe((data)=>this.message=data) //data me resp milega and hum uuse msg me assign kr rahe hai
    
  }

}
