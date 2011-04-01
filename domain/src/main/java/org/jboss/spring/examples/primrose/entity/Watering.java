package org.jboss.spring.examples.primrose.entity;

public enum Watering
{
   DAILY(1),
   TWICE_A_WEEK(3),
   WEEKLY(7),
   MONTHLY(30);

   private int timeDelay;

   Watering(int timeDelay)
   {
      this.timeDelay = timeDelay;
   }

   /**
    * @return the timeDelay
    */
   public int getTimeDelay()
   {
      return timeDelay;
   }

   /**
    * @param timeDelay the timeDelay to set
    */
   public void setTimeDelay(int timeDelay)
   {
      this.timeDelay = timeDelay;
   }

}
