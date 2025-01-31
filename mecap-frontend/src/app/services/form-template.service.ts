import { Injectable } from "@angular/core";
import { UserTrackableFormTemplate } from "../models/form-templates/user-trackable-form-template.model";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
@Injectable({
    // Single instance, rather than multiple copies accross different modules.
    providedIn: 'root' // application wide, no module needed.
})
export class FormTemplateService{
    constructor(private httpClient: HttpClient){}

    getAllUserFormTemplates(userId: number) {
        // api call and return of 
        // subscribe to an observable ( the request ) and return the form templates
        return this.httpClient.get<UserTrackableFormTemplate[]>('http://localhost:8080/TrackableFormTemplate/get-active-templates');
    }
}