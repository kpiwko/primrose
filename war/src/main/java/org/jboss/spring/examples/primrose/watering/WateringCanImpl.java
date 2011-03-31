package org.jboss.spring.examples.primrose.watering;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.jboss.spring.examples.primrose.dao.FlowerDao;
import org.jboss.spring.examples.primrose.dta.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WateringCanImpl implements WateringCan
{
   @Autowired
   FlowerDao flowerDao;

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
            System.out.println("Flower " + f.getGenus() + " " + f.getLocation() + " was watered");
         }
         else
         {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, f.getWatering().getTimeDelay());
            if (cal.getTime().after(today))
            {
               flowerDao.water(f, amount);
               f.setLastWatered(today);
               System.out.println("Flower " + f.getGenus() + " " + f.getLocation() + " was watered");
            }
         }

      }

   }
}
