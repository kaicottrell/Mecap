package com.mecap.self_tracking_backend.entities.trackableform;

import com.mecap.self_tracking_backend.enums.TemplateOccurance;
import com.mecap.self_tracking_backend.enums.TrackableTemplateStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//TODO: Need default contructor with no params?
@Entity
public class UserTrackableFormTemplate {
	@Id
	@GeneratedValue // Sequence would be created and used to set value
	private Long id;
	private TemplateOccurance occuranceInterval;
	private TrackableTemplateStatus status;
	private Long userId;
	private String name;
	private String colorHexValue;
	
	public String getName() {
		return name;
	}

	public UserTrackableFormTemplate(TemplateOccurance occuranceInterval, TrackableTemplateStatus status,
			Long userId, String name, String colorHexValue) {
		super();
		this.occuranceInterval = occuranceInterval;
		this.status = status;
		this.userId = userId;
		this.name = name;
		this.colorHexValue = colorHexValue;
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


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public TrackableTemplateStatus getStatus() {
		return status;
	}

	public void setStatus(TrackableTemplateStatus status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	//TODO: Introduce themes

	public TemplateOccurance getOccuranceInterval() {
		return occuranceInterval;
	}

	public void setOccuranceInterval(TemplateOccurance occurance) {
		this.occuranceInterval = occurance;
	}
}

