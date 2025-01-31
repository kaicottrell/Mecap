import { TemplateOccurance } from "./enums/template-occurance.enum";
import { TemplateStatus } from "./enums/template-status.enum";
export interface UserTrackableFormTemplate{
    id: number;   
    occuranceInterval: TemplateOccurance;
    status: TemplateStatus;
    userId: number;
    name: string;
    colorHexValue: string;
}