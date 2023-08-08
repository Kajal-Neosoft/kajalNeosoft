import { Injectable } from '@angular/core';
import { Page } from './page.interface';
import { HttpClient, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';
import { employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeListService {

  private baseUrl = "http://localhost:8080";
  constructor(private http: HttpClient) { }

  getAllEmployees(page: number,size: number): Observable<Page<employee>>
  {
    const params = new HttpParams()
    .set('pageNo', page.toString())
    .set('pageSize', size.toString());

    return this.http.get<Page<employee>>(`${this.baseUrl}/getAllEmployee`, { params });

  }

}
