import { Component } from '@angular/core';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { RouterLink } from '@angular/router';
@Component({
  selector: 'app-form-template-upsert',
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './form-template-upsert.component.html',
  styleUrl: './form-template-upsert.component.css'
})
export class FormTemplateUpsertComponent {
  upsertForm = new FormGroup({
    title: new FormControl(''),
    description: new FormControl('')
  });
  handleNewTemplate(){
    
  }
}
