package org.jboss.spring.examples.primrose.messaging;

import org.jboss.spring.examples.primrose.entity.WateringNotification;
import org.jboss.spring.examples.primrose.watering.WateringCan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WateringNotificationProcessor
{
   @Autowired
   private WateringCan wateringCan;

   public void processWateringNotification(WateringNotification wateringNotification)
   {
      System.out.println(wateringNotification + " received");
      wateringCan.waterAt(wateringNotification.getLocation(), wateringNotification.getAmount());
      System.out.println(wateringNotification + " fullfiled");
   }

}
