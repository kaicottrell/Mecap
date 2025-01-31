import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UserFormTemplatesComponent } from './user-form-templates/user-form-templates.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, UserFormTemplatesComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'mecap-frontend';
}
