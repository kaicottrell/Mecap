package com.mecap.self_tracking_backend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mecap.self_tracking_backend.entities.trackableform.UserTrackableFormTemplate;
import com.mecap.self_tracking_backend.repositories.ITrackableFormTemplateRepository;

//Q: How does the path work on this controller? is it inferred to be /TrackableFormTemplate/... ?
@RestController
//A: not by default. By default it would be based off of soley the method level mapping. BUT with RequestMapping at the class level this can be added.
@RequestMapping("/TrackableFormTemplate")
public class TrackableFormTemplateController {
	@Autowired
	ITrackableFormTemplateRepository trackableFormTemplateRepo;
	//create a new TrackableFormTemplate
	@GetMapping("/PingActiveTemplates")
	public boolean doesActiveFormTemplateExist() {
		List<UserTrackableFormTemplate> templateList = new ArrayList<>();
		templateList = trackableFormTemplateRepo.listByUserId(0l);
		return templateList.size() > 0;
	}
}
