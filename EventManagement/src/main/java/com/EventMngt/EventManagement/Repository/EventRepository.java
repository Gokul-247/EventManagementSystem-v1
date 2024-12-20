package com.EventMngt.EventManagement.Repository;

import com.EventMngt.EventManagement.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    List<Event> findByCategoryName(String categoryName);
}
