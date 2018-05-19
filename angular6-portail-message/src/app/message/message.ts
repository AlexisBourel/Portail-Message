import { User } from "../user/user";
import { Tournee } from "../tournee/tournee";

export class Message {
    
    id: number;
    titre: String;
    contenu: String;
    date: Date;
    auteur: User;
    tournee: Tournee;

}