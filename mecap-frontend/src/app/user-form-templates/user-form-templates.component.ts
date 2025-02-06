import { Component, OnInit, signal } from '@angular/core';
import { UserTrackableFormTemplate } from '../models/form-templates/user-trackable-form-template.model';
import { FormTemplateService } from '../services/form-template.service';
import { NgClass } from '@angular/common';
//Standlone by default, meaning it does not require being declared in a NGModule
@Component({
  selector: 'app-user-form-templates',
  imports: [NgClass],
  templateUrl: './user-form-templates.component.html',
  styleUrl: './user-form-templates.component.css'
})
export class UserFormTemplatesComponent implements OnInit{
  userFormTemplateList: UserTrackableFormTemplate[] = [];
  showNewTemplate = signal(false);
  
  constructor(private formTemplateService: FormTemplateService){

  }
  ngOnInit(): void{
    this.formTemplateService.getAllUserFormTemplates(0).subscribe(
      //observable object
      {
        next: (response) => {
          this.userFormTemplateList = response;
        },
         // add complete, error etc.
         complete: () => console.log(this.userFormTemplateList)
      }
    );
  }
  onShowTemplateCreation(){
    this.showNewTemplate.set(true);
  }
  //TODO: bind to the form inputs with NgModel and utilize the add template function in the service.
  // update the list of user form templates

  handleNewTemplate(){
    
  }
  cancelNewTemplate(){
    // clear all forms from reactive form (form group)
    // close modal
    this.showNewTemplate.set(false);
  }


}
