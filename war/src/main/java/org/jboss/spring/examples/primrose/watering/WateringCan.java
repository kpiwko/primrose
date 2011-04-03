package org.jboss.spring.examples.primrose.watering;

public interface WateringCan
{
   void waterAt(String location, Double amount);
   
   void water(long id, Double amount);
}
