package org.jboss.spring.examples.primrose.wstest;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.Test;

public class WaterFlowersTestCase
{
   private static final String TARGET_NS = "http://ws.primrose.examples.spring.jboss.org/";
   private static final String WSDL_URL = "http://127.0.0.1:8080/primrose/ws/water?wsdl";
   private static final String SERVICE_NAME = "WateringServiceService";

   @Test
   public void waterFlowers() throws Exception
   {
      URL wsdlURL = new URL(WSDL_URL);
      QName serviceName = new QName(TARGET_NS, SERVICE_NAME);

      Service service = Service.create(wsdlURL, serviceName);
      WateringService port = service.getPort(WateringService.class);

      // water all flowers on Balcony with a galon of water
      port.notifyWatering("Balcony", 4.0);
   }
}
