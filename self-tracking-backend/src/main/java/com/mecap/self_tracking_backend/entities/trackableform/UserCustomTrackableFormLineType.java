 package com.mecap.self_tracking_backend.entities.trackableform;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//Stores the custom type for custom options for TrackableFormLines
@Entity
public class UserCustomTrackableFormLineType {
	@Id
	@GeneratedValue // Sequence would be created and used to set value
	private Long id;
	private String content;
	private String typeName;
    public UserCustomTrackableFormLineType() { }
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
