import { a } from "@angular/core/src/render3";

export class User {
    first_name: string;
    last_name: string;
    telephone: string;
    address: string;
    id: string;
    email: string;
    password: string;
    isManager: boolean;
    identity: number;
    
    
    
    // public get identity(): number {
    //     return this._identity;
    // }
    // public set identity(value: number) {
    //     this._identity = value;
    // }

    // static counter: number = 0;
    
    constructor(first_name: string,
        last_name: string,
        telephone: string,
        address: string,
        id: string,
        email: string,
        password: string,
        isManager: boolean) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.address = address;
        this.email = email;
        this.id = id;
        this.password = password;
        this.telephone = telephone;
        this.isManager = isManager;
        // this.identity = User.counter++;
    }
  
}

