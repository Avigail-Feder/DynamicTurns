

export class Meeting {
    id?: number;
    subject?: string;
    startTime?: Date;
    endTime?: Date;
    destId?:string;
    customerId?: string;

    /**
     * toString
     */
    public toString(): string {
        console.log(this.destId+' '+this.startTime+' '+this.endTime);
        return 'id ' + this.id.toString() + ' subject ' + this.subject + ' startTime ' + this.startTime.toString() + ' endTime ' + this.endTime.toString() + ' cusomerId ' + this.customerId;
    }
   
}
