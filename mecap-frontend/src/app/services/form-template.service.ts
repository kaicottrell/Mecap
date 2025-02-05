import { Injectable, signal } from '@angular/core';
import { UserTrackableFormTemplate } from '../models/form-templates/user-trackable-form-template.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserTrackableFormTemplateRequest } from '../models/form-templates/requests/user-trackable-form-template.request';

@Injectable({
  // Single instance, rather than multiple copies accross different modules.
  providedIn: 'root', // application wide, no module needed.
})
export class FormTemplateService {
  constructor(private httpClient: HttpClient) {}

  getAllUserFormTemplates(userId: number): Observable<UserTrackableFormTemplate[]> {
    return this.httpClient.get<UserTrackableFormTemplate[]>(
      'http://localhost:8080/TrackableFormTemplate/get-active-templates'
    );
  }
  addUserFormTemplate(formTemplateRequest: UserTrackableFormTemplateRequest) {
    this.httpClient.post('http://localhost:8080/TrackableFormTemplate/create-template', formTemplateRequest)
  }
  
}
