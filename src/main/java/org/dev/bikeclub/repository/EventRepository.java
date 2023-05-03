package org.dev.bikeclub.repository;

import org.dev.bikeclub.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
