import { Component, OnInit, signal } from '@angular/core';
import { UserTrackableFormTemplate } from '../models/form-templates/user-trackable-form-template.model';
import { FormTemplateService } from '../services/form-template.service';
import { NgClass } from '@angular/common';
import { RouterLink, RouterOutlet } from '@angular/router';
//Standlone by default, meaning it does not require being declared in a NGModule
@Component({
  selector: 'app-user-form-templates',
  imports: [RouterOutlet, RouterLink],
  templateUrl: './user-form-templates.component.html',
  styleUrl: './user-form-templates.component.css'
})
export class UserFormTemplatesComponent {



}
