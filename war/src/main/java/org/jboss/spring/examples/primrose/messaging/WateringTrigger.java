package org.jboss.spring.examples.primrose.messaging;

import org.jboss.spring.examples.primrose.entity.WateringNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@ManagedResource(objectName = "primrose:name=wateringNotificationTrigger", description = "Watering Notification Trigger")
@Component
public class WateringTrigger
{
   @Autowired
   private JmsTemplate jmsTemplate;

   @ManagedOperation(description = "Send Watering Notification")
   public void sendPaymentNotification(
         @ManagedOperationParameter(name = "location", description = "Location of flowers") String location,
         @ManagedOperationParameter(name = "amount", description = "Amount of water") double amount)
   {
      WateringNotification wateringNotification = new WateringNotification();
      wateringNotification.setLocation(location);
      wateringNotification.setAmount(amount);
      jmsTemplate.convertAndSend(wateringNotification);
      System.out.println(wateringNotification + " send to message queue");
   }
}
