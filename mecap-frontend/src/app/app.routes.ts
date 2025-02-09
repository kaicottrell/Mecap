import { Routes } from '@angular/router';
import { UserFormTemplatesComponent } from './user-form-templates/user-form-templates.component';
import { FormTemplateUpsertComponent } from './user-form-templates/form-template-upsert/form-template-upsert.component';
import { FormTemplateListComponent } from './user-form-templates/form-template-list/form-template-list.component';

// Highest level of routes. Starting at the application root
export const appRoutes: Routes = [
    {
        path:'', //'my-templates', // TODO: 
        component: UserFormTemplatesComponent,
        children: [
            {
                path: 'upsert',
                component: FormTemplateUpsertComponent
                //TODO: new template
            },
            {
                path: 'list',
                component: FormTemplateListComponent
                //TODO: new template
            },
            // essentially my-templates alone would redirect to the list
            {
                path: '', 
                redirectTo: 'list', 
                pathMatch: 'full'
            }
        ] 
    }
];
