package com.management.UniversityEventManagement.repository;
import com.management.UniversityEventManagement.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventRepository extends JpaRepository<Event,Integer> {
}
