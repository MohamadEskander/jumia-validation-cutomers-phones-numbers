import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; 
import { Customer } from '../model/customer'; 
import { Observable } from 'rxjs'; 
import { map } from 'rxjs/operators'; 
import { environment } from '../../environments/environment';


@Injectable({
  providedIn: 'root' 
})
export class CustomerService {

  constructor(private httpClient: HttpClient) { }

  getCustomersList(state: String,country: String): Observable<Customer[]> {
      return this.httpClient.get<Customer[]>(`${environment.customersUrl}`).pipe(
          map(response => response)
      );
  }

  getFilteredCustomersList(state: String,country: String): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(`${environment.customersUrl+'/filter'}?state=${state}&country=${country}`).pipe(
        map(response => response)
    );
}

}
