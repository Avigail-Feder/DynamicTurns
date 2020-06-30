export class Message {
    code: number;
    userId: string;
    content: string;

    constructor(code: number, userId: string, content: string) {
        this.code = code;
        this.userId = userId;
        this.content = content;
    }
   

}
