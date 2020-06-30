export class Request {
    code: number;

    requesterId: string;
    requester_meetingId: number;
    dateToChange: Date;

    responderId: string;
    responder_meetingId: number;

    constructor(code: number,
        requesterId: string,
        requester_meetingId: number,
        dateToChange: Date,
        responderId: string,
        responder_meetingId: number) {
        this.code = code;
        this.requesterId = requesterId;
        this.requester_meetingId = requester_meetingId;
        this.dateToChange = dateToChange;
        this.responderId = responderId;
        this.responder_meetingId = responder_meetingId;
    }
}
