import { User } from "./user";
import { Tour } from "./tour";


export class Message {    
    id: number;
    title: String;
    content: String;
    createdAt: Date;
    autor: User;
    tour: Tour;
    updateAt: Date;
    updateBy: User;
    expiryDate: Date;
}