package org.jboss.spring.examples.primrose.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.jboss.annotation.spring.Spring;
import org.jboss.ejb3.annotation.LocalBinding;
import org.jboss.spring.callback.SpringLifecycleInterceptor;
import org.jboss.spring.examples.primrose.dao.FlowerDao;
import org.jboss.spring.examples.primrose.entity.Flower;
import org.jboss.spring.examples.primrose.entity.Watering;

@Stateless
@LocalBinding(jndiBinding = "primrose/FlowerService")
@Interceptors(SpringLifecycleInterceptor.class)
public class FlowerServiceImpl implements FlowerService
{
   @Spring(bean = "flowerDao", jndiName = "SpringDao")
   private FlowerDao flowerDao;

   public FlowerDao getFlowerDao()
   {
      return flowerDao;
   }

   public void setFlowerDao(FlowerDao flowerDao)
   {
      this.flowerDao = flowerDao;
   }

   public List<Flower> getAllFlowers()
   {
      return flowerDao.getAllFlowers();
   }

   public int getFlowersCountAt(String location)
   {
      return flowerDao.getForLocation(location).size();
   }

   public Flower plantFlower(String genus, String species, String location, Watering watering)
   {
      Flower flower = new Flower();
      flower.setGenus(genus);
      flower.setSpecies(species);
      flower.setLocation(location);
      flower.setWatering(watering);
      flower.setLastWatered(new Date());

      flowerDao.create(flower);
      return flower;
   }

   public Flower find(long id)
   {
      return flowerDao.find(id);
   }

   public void throwAway(long id)
   {
      Flower flower = flowerDao.find(id);
      if (flower != null)
      {
         flowerDao.delete(flower);
      }
   }
   
}
