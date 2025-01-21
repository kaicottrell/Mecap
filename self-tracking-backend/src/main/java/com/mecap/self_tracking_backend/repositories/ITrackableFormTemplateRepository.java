package com.mecap.self_tracking_backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mecap.self_tracking_backend.entities.trackableform.UserTrackableFormTemplate;

// Note: Spring Dynamically generates a class that implements the inteface.
@Repository
public interface ITrackableFormTemplateRepository extends CrudRepository<UserTrackableFormTemplate, Long> {
	@Query("SELECT utft FROM userTrackableFormTemplate utft WHERE userId = ?")
	List<UserTrackableFormTemplate> listByUserId(Long userId);
	
}
