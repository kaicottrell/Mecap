package com.mecap.self_tracking_backend.entities.trackableform;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class UserTrackableFormTemplate {
	@Id
	@GeneratedValue // Sequence would be created and used to set value
	private Long id;
	private TemplateOccurance occuranceInterval;
	private TrackableTemplateStatus status;
	private Long userId;
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
enum TemplateOccurance{
	DAILY, MONTHLY, BIMONTHLY,QUARTERLY,YEARLY
}
enum TrackableTemplateStatus{
	ACTIVE, INACTIVE, REMOVED // REMOVED is a soft delete 
}
