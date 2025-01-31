import { Component, OnInit } from '@angular/core';
import { UserTrackableFormTemplate } from '../models/form-templates/user-trackable-form-template.model';
import { FormTemplateService } from '../services/form-template.service';
//Standlone by default, meaning it does not require being declared in a NGModule
@Component({
  selector: 'app-user-form-templates',
  imports: [],
  templateUrl: './user-form-templates.component.html',
  styleUrl: './user-form-templates.component.css'
})
export class UserFormTemplatesComponent implements OnInit{
  userFormTemplateList: UserTrackableFormTemplate[] = [];
  
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


}
