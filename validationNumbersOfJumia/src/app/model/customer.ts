export class Customer {

    id: number;
    name: String;
    phone: String;
    state: String;
    country: String;

    constructor(public c_Id: number, public c_Name: String, public c_Phone: String, public c_State: String, public c_Country: String)
     { 
         this.id=c_Id;
         this.name = c_Name;
         this.phone = c_Phone;
         this.state = c_State;
         this.country = c_Country;
     }


}
