package org.jboss.spring.examples.primrose.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.spring.examples.primrose.entity.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class FlowerDaoImpl implements FlowerDao
{
   @Autowired
   EntityManager em;

   public List<Flower> getAllFlowers()
   {
      return em.createQuery("from Flower").getResultList();
   }

   public List<Flower> getForLocation(String location)
   {
      return em.createQuery("from Flower where location = :location")
            .setParameter("location", location).getResultList();
   }

   public Flower water(Flower flower, double amount)
   {
      flower.setLastWatered(new Date());
      em.persist(flower);
      return flower;
   }

   public void create(Flower flower)
   {
      em.persist(flower);
   }

   public void delete(Flower flower)
   {
      em.remove(flower);
   }

   public Flower find(long id)
   {
      return em.find(Flower.class, id);
   }
}
