package org.jboss.spring.examples.primrose.dao;

import java.util.List;

import org.jboss.spring.examples.primrose.dta.Flower;

public interface FlowerDao
{
   List<Flower> getAllFlowers();
   
   List<Flower> getForLocation(String location);
   
   Flower water(Flower flower, double amount);
   
   void create(Flower flower);
   
   Flower find(long id);
   
   void delete(Flower flower);
   
}
