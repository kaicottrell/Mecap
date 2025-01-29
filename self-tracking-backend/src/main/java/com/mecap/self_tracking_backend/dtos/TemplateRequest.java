package com.mecap.self_tracking_backend.dtos;

import com.mecap.self_tracking_backend.enums.TemplateOccurance;
import com.mecap.self_tracking_backend.enums.TrackableTemplateStatus;

public class TemplateRequest {
	private TemplateOccurance occurance;
	private TrackableTemplateStatus templateStatus;
	private long userId;
	private String name; 
	private String colorHexValue;
	public TemplateOccurance getOccurance() {
		return occurance;
	}
	public void setOccurance(TemplateOccurance occurance) {
		this.occurance = occurance;
	}
	public TrackableTemplateStatus getTemplateStatus() {
		return templateStatus;
	}
	public void setTemplateStatus(TrackableTemplateStatus templateStatus) {
		this.templateStatus = templateStatus;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColorHexValue() {
		return colorHexValue;
	}
	public void setColorHexValue(String colorHexValue) {
		this.colorHexValue = colorHexValue;
	}
	
	
}
