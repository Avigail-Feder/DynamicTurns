export class Destination {
    id: string;
    firstName: string;
    lastName: string;
    eMail: string;
    description: string;


    constructor(id: string, firstName: string, lastName: string, desc: string ,eMail: string) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.eMail = eMail;
        this.description = desc;

    }



}
