package com.EventMngt.EventManagement.Service;

import com.EventMngt.EventManagement.Model.EventRequest;
import com.EventMngt.EventManagement.Model.EventResponse;

import java.util.List;

public interface EventService {
    EventResponse createEvent(EventRequest eventRequest);

    List<EventResponse> getEventsByCategory(String categoryName);
}
