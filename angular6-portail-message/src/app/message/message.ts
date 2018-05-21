import { User } from "../user/user";
import { Tour } from "../tour/tour";

export class Message {    
    id: number;
    title: String;
    content: String;
    createdAt: Date;
    autor: User;
    tour: Tour;
    updateAt: Date;
    updateBy: Date;
    dateExpiration: Date;
}