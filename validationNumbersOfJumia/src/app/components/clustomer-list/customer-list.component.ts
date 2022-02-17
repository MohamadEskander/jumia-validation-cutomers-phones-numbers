import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { Customer } from 'src/app/model/customer';

import { MatTableDataSource } from '@angular/material/table';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DatePipe } from '@angular/common';
import { State } from 'src/app/enumiration/state.enum';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Country } from 'src/app/enumiration/country.enum';



@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  constructor(private customerService: CustomerService) { }

  customers: Customer[];
  state: string;
  country: string;

  states = Object.keys(State)
                    .map(h => State[h as any])
                    .filter(value => typeof value === 'string') as string[];

  countries = Object.keys(Country)
                    .map(h => Country[h as any])
                    .filter(value => typeof value === 'string') as string[];
  ngOnInit() {
    this.state = "";
    this.country = "";
    this.listCustomers();
  }

  listCustomers() {
    this.customerService.getCustomersList(this.state, this.country).subscribe(
      data => {
        this.customers = data;
        console.log(this.customers);

      }
    )
  }

  listFilteredCustomers() {
    this.customerService.getFilteredCustomersList(this.state, this.country).subscribe(
      data => {
        this.customers = data;
        console.log(this.customers);

      }
    )
  }

  filter(keyword: any, filterBy: any) {
    filterBy == 'state' ? this.state = keyword : this.country = keyword;

    if (filterBy == 'state' && keyword) {
      this.state = keyword;
    } if (filterBy == 'state' && keyword =="0") {
      this.state = "";
    }

    if (filterBy == 'country' && keyword) {
      this.country = keyword;

    } if (filterBy == 'country' && keyword =="0") {
      this.country = "";
    }

    this.listFilteredCustomers();

  }

}