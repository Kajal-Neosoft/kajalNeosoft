import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {
  // we need to call our backend api for that using httpclient
  constructor(private http:HttpClient) { }

  // write the method

  public doRegistration(user:User)
  {
    //response type i can get the response in string format
    return this.http.post("http://localhost:8080/register",user,{responseType:'text' as 'json'});
  }

  public getUsers()
  {
    //response type i can get the response in string format
    return this.http.get("http://localhost:8080/getAllUsers");
  }

  public getUserByEmail(email:any)
  {
    return this.http.get("http://localhost:8080/findUser/"+email);
  }

  public deleteUser(id:any)
  {
    return this.http.delete("http://localhost:8080/cancel/"+id)
  }

  

}
