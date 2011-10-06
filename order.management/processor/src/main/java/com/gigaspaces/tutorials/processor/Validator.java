package com.gigaspaces.tutorials.processor;

import com.gigaspaces.tutorials.common.builder.OrderEventBuilder;
import com.gigaspaces.tutorials.common.model.OrderEvent;
import com.gigaspaces.tutorials.common.model.Status;
import com.gigaspaces.tutorials.common.service.AccountDataService;
import org.openspaces.events.EventDriven;
import org.openspaces.events.EventTemplate;
import org.openspaces.events.adapter.SpaceDataEvent;
import org.openspaces.events.polling.Polling;
import org.springframework.beans.factory.annotation.Autowired;

@EventDriven
@Polling
public class Validator {
  @Autowired
  AccountDataService service;

  @EventTemplate
  public OrderEvent getTemplate() {
    return new OrderEventBuilder()
           .status(Status.NEW)
           .build();
  }

  @SpaceDataEvent
  public OrderEvent handleEvent(OrderEvent event) {
    if (!service.accountExists(event.getUserName())) {
      event.setStatus(Status.ACCOUNT_NOT_FOUND);
    } else {
      event.setStatus(Status.PENDING);
    }
    // build a new event - necessary?
    event.setId(null);
    return event;
  }
}
