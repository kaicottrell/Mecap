import {TemplateOccurance} from '../enums/template-occurance.enum';
import {TemplateStatus} from '../enums/template-status.enum';
export interface UserTrackableFormTemplateRequest{
    occurance: string;
    templateStatus: string;
    userId: number;
    name: string;
    colorHexValue: string;
    description: string;
}