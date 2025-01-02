package com.mecap.self_tracking_backend.entities.trackableform;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserCustomTrackableFormLineOption {
	@Id
	private Long id;
	private String content;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="line_type_id")
	private UserCustomTrackableFormLineType lineType;
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
	public UserCustomTrackableFormLineType getLineType() {
		return lineType;
	}
	public void setLineType(UserCustomTrackableFormLineType lineType) {
		this.lineType = lineType;
	}
	
	
}
