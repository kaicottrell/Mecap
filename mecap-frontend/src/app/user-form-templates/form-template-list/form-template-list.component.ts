import { Component } from '@angular/core';
import { UserTrackableFormTemplate } from '../../models/form-templates/user-trackable-form-template.model';
import { FormTemplateService } from '../../services/form-template.service';
import { RouterLink } from '@angular/router';
import { tmplAstVisitAll } from '@angular/compiler';

@Component({
  selector: 'app-form-template-list',
  imports: [RouterLink],
  templateUrl: './form-template-list.component.html',
  styleUrl: './form-template-list.component.css'
})
export class FormTemplateListComponent {
  formTemplateList: UserTrackableFormTemplate[] = [];
  //TODO: utilize the path parameters as an input to get this specific users inputs
  constructor(private formTemplateService: FormTemplateService){
    
  }

  ngOnInit(): void{
    this.formTemplateService.getAllUserFormTemplates(0).subscribe(
      //observable object
      {
        next: (response) => {
          this.formTemplateList = response;
        },
         // add complete, error etc.
         complete: () => console.log(this.formTemplateList)
      }
    );
  }
  deleteTemplate(templateId: number){
    const oldTemplateList = this.formTemplateList;

    this.formTemplateService.deleteTemplate(templateId).subscribe({
      next: () => {
        const newTemplateList = this.formTemplateList.filter((formTemplate) => formTemplate.id != templateId );
        this.formTemplateList = [...newTemplateList];
        console.log('successful deletion of template id : ' + templateId)
      },
      //reset change
      error: () => ( this.formTemplateList = [...oldTemplateList])
    });

  }
}
