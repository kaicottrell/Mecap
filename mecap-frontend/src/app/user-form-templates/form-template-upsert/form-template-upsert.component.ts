import { Component, input, OnInit } from '@angular/core';
import {
  FormArray,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { RouterLink, Router } from '@angular/router';
import { TemplateOccurance } from '../../models/form-templates/enums/template-occurance.enum';
import { TemplateStatus } from '../../models/form-templates/enums/template-status.enum';
import { FormTemplateService } from '../../services/form-template.service';
import { getEnumKeyByValue, getEnumValueByKey } from '../../models/form-templates/enums/enum.helper';
import { UserTrackableFormTemplateRequest } from '../../models/form-templates/requests/user-trackable-form-template.request';
import { UserTrackableFormTemplate } from '../../models/form-templates/user-trackable-form-template.model';
@Component({
  selector: 'app-form-template-upsert',
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './form-template-upsert.component.html',
  styleUrl: './form-template-upsert.component.css',
})
export class FormTemplateUpsertComponent implements OnInit {
  // optional input parameter for updating.
  formTemplateId = input<number | null>(null);
  upsertForm = new FormGroup<{ [key: string]: any }>({
    templateName: new FormControl(''),
    description: new FormControl(''),
    colorHexValue: new FormControl(''), // color picker TODO: add validators
    templateOccuranceType: new FormControl<TemplateOccurance>(
      TemplateOccurance.MONTHLY
    ),
    templateStatus: new FormControl<TemplateStatus>(TemplateStatus.ACTIVE),
  });
  templateOccuranceTypeTupleArr = Object.entries(TemplateOccurance);
  templateStatusTypeTupleArr = Object.entries(TemplateStatus);
  constructor(
    private templateService: FormTemplateService,
    private router: Router
  ) {}
  ngOnInit(): void {
    // Updating
    if (this.formTemplateId()) {
      let formData: UserTrackableFormTemplate;
      this.templateService.getTemplate(this.formTemplateId()!).subscribe({
        next: (response) => {
          formData = response;
          console.log("Interval " + formData.occuranceInterval);
          this.upsertForm.patchValue({
            templateName: formData.name,
            description: formData.description,
            colorHexValue: formData.colorHexValue,
            templateOccuranceType: getEnumValueByKey(TemplateOccurance, formData.occuranceInterval) ,
            templateStatus: getEnumValueByKey(TemplateStatus, formData.status) 
          })
        },
        error: () =>
          console.log('There was an error getting the selected template.'),
      });
    
    }
  }
  handleNewTemplate() {
    // console.log(this.upsertForm)
    const selectedTmpOccurance = this.upsertForm.controls[
      'templateOccuranceType'
    ].value as TemplateOccurance;
    const selectedTmpStatus = this.upsertForm.controls['templateStatus']
      .value as TemplateStatus;
    const selectedTmpName = this.upsertForm.controls['templateName']
      .value as string;
    const selectedTmpColor = this.upsertForm.controls['colorHexValue']
      .value as string;
    const selectedTmpDescription = this.upsertForm.controls['description']
      .value as string;

    const parsedTmpOcc =
      getEnumKeyByValue(TemplateOccurance, selectedTmpOccurance) ||
      TemplateOccurance.MONTHLY;
    const parsedTmpStatus =
      getEnumKeyByValue(TemplateStatus, selectedTmpStatus) ||
      TemplateStatus.ACTIVE;

    if(this.formTemplateId()){
      console.log("Updating");
      this.templateService.updateTemplate({
        id: this.formTemplateId()!,
        occuranceInterval: parsedTmpOcc,
        status: parsedTmpStatus,
        userId: 0,
        name: selectedTmpName,
        colorHexValue: selectedTmpColor,
        description: selectedTmpDescription,
      }).subscribe({
        next: () => {
          this.router.navigate(['../']);
        },
      });
    } else { // create
      this.templateService
      .addUserFormTemplate({
        // occuranceInterval: selectedTmpOccurance,
        // status: selectedTmpStatus,
        occurance: parsedTmpOcc,
        templateStatus: parsedTmpStatus,
        userId: 0,
        name: selectedTmpName,
        colorHexValue: selectedTmpColor,
        description: selectedTmpDescription,
      })
      .subscribe({
        next: () => {
          this.router.navigate(['../']);
        },
      });
    }
  
  }
}
