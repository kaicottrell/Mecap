package com.mecap.self_tracking_backend.services;
import java.util.ArrayList;
import java.util.List;
import com.mecap.self_tracking_backend.enums.TemplateOccurance;
import com.mecap.self_tracking_backend.enums.TrackableTemplateStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mecap.self_tracking_backend.entities.trackableform.UserTrackableFormTemplate;
import com.mecap.self_tracking_backend.repositories.ITrackableFormTemplateRepository;

//TODO: add success / fail messages 
@Service
public class FormTemplateService {
	@Autowired
	ITrackableFormTemplateRepository trackableFormTemplateRepo;
	public ArrayList<UserTrackableFormTemplate> listAll(){
		return (ArrayList<UserTrackableFormTemplate>)trackableFormTemplateRepo.findAll();
	}
	//TODO: change depending on the key of the user id 
//	public List<UserTrackableFormTemplate> listByUserId(long userId){
//		return (List<UserTrackableFormTemplate>)trackableFormTemplateRepo.listByUserId(userId);
//	}
	// necessary to build a user trackable template: TemplateOccurance occurance, TrackableTemplateStatus templateStatus, long userId, String name, String colorHexValue
	public void add(UserTrackableFormTemplate userFormTemplate) {
		trackableFormTemplateRepo.save(userFormTemplate);
	}
	public void deleteById(long id) {
		trackableFormTemplateRepo.deleteById(id);
	}
}
