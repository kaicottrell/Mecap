package com.mecap.self_tracking_backend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mecap.self_tracking_backend.dtos.TemplateRequest;
import com.mecap.self_tracking_backend.entities.trackableform.UserTrackableFormTemplate;
import com.mecap.self_tracking_backend.enums.TemplateOccurance;
import com.mecap.self_tracking_backend.enums.TrackableTemplateStatus;
import com.mecap.self_tracking_backend.repositories.ITrackableFormTemplateRepository;
import com.mecap.self_tracking_backend.services.FormTemplateService;

//Q: How does the path work on this controller? is it inferred to be /TrackableFormTemplate/... ?
@RestController
//A: not by default. By default it would be based off of soley the method level mapping. BUT with RequestMapping at the class level this can be added.
@RequestMapping("/TrackableFormTemplate")
@CrossOrigin(origins = "*")  // Allows requests from any origin
public class TrackableFormTemplateController {
	@Autowired
	private FormTemplateService formTemplateService;
	//create a new TrackableFormTemplate
	@GetMapping("/ping-active-templates")
	public boolean doTemplatesExist() {
		List<UserTrackableFormTemplate> templateList = new ArrayList<>();
		//templateList = formTemplateService.listByUserId(0l);
		return templateList.size() > 0;
	}
	// list active templates
	//TODO: get the user id from the request body
	@GetMapping("/get-active-templates")
	public List<UserTrackableFormTemplate> getTemplates(){
		List<UserTrackableFormTemplate> userTemplateList = new ArrayList<UserTrackableFormTemplate>();
		//userTemplateList = trackableFormTemplateRepo.listByUserId(null)
		userTemplateList = formTemplateService.listAll();
		return userTemplateList;
	}
	
	// ? - means unknown type: can work with any type but I dont know or dont care
	@PostMapping("/create-template")
	public ResponseEntity<?> createTemplate(@RequestBody TemplateRequest templateData) {
		try {
			// Create the new template object. 
			UserTrackableFormTemplate newFormTemplate = new UserTrackableFormTemplate(
					templateData.getOccurance(),
					templateData.getTemplateStatus(),
					templateData.getUserId(),
					templateData.getName(),
					templateData.getColorHexValue()
			);
			formTemplateService.add(newFormTemplate);
			return ResponseEntity.ok().build();
					
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	// utilizing a path variable
	@DeleteMapping("/delete/{templateId}")
	public ResponseEntity<?> deleteTemplate(@PathVariable long templateId){
		formTemplateService.deleteById(templateId);
		return ResponseEntity.ok(templateId);
	}
	
	
}
