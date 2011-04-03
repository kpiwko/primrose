package org.jboss.spring.examples.primrose.watering;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.jboss.spring.examples.primrose.dao.FlowerDao;
import org.jboss.spring.examples.primrose.entity.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class WateringCanImpl implements WateringCan
{
   @Autowired
   FlowerDao flowerDao;

   @Transactional
   public void waterAt(String location, Double amount)
   {
      List<Flower> flowers = flowerDao.getForLocation(location);

      Date today = new Date();
      for (Flower f : flowers)
      {
         Date last = f.getLastWatered();
         if (last == null)
         {
            flowerDao.water(f, amount);
            System.out.println("Flower " + f.getGenus() + " on " + f.getLocation() + " was watered");
         }
         else
         {
            Calendar cal = Calendar.getInstance();
            cal.setTime(last);
            // emulating a day with 3 seconds
            cal.add(Calendar.SECOND, f.getWatering().getTimeDelay() * 3);
            if (cal.getTime().before(today))
            {
               flowerDao.water(f, amount);
               System.out.println("Flower " + f.getGenus() + " on " + f.getLocation() + " was watered");
            }
         }

      }

   }
   
   @Transactional
   public void water(long id, Double amount)
   {
      Flower flower = flowerDao.find(id);
      if(flower!=null) {
         flowerDao.water(flower, amount);
         System.out.println("Flower " + flower.getGenus() + " on " + flower.getLocation() + " was watered");
      }
   }
}
