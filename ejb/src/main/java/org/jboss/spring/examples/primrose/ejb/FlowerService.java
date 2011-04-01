package org.jboss.spring.examples.primrose.ejb;

import java.util.List;

import javax.ejb.Local;

import org.jboss.spring.examples.primrose.entity.Flower;
import org.jboss.spring.examples.primrose.entity.Watering;

@Local
public interface FlowerService
{
   List<Flower> getAllFlowers();
   
   int getFlowersCountAt(String location);

   Flower find(long id);
   
   Flower plantFlower(String genus, String species, String location, Watering watering);

   void throwAway(long id);
}
