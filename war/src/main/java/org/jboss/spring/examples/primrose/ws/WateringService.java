package org.jboss.spring.examples.primrose.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.jboss.spring.examples.primrose.watering.WateringCan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebService
public class WateringService extends SpringBeanAutowiringSupport
{
   @Autowired
   private WateringCan wateringCan;

   @WebMethod
   public void notifyWatering(String location, Double amount)
   {
      wateringCan.waterAt(location, amount);
   }
}
