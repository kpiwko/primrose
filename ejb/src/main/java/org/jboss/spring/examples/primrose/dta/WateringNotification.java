package org.jboss.spring.examples.primrose.dta;

public class WateringNotification
{
   private String location;
   private Double amount;

   /**
    * @return the location
    */
   public String getLocation()
   {
      return location;
   }

   /**
    * @param location the location to set
    */
   public void setLocation(String location)
   {
      this.location = location;
   }

   /**
    * @return the amount
    */
   public Double getAmount()
   {
      return amount;
   }

   /**
    * @param amount the amount to set
    */
   public void setAmount(Double amount)
   {
      this.amount = amount;
   }

   @Override
   public String toString()
   {
      return "Watering notification for flowers at " + location + " with " + amount + "l water";
   }

}
