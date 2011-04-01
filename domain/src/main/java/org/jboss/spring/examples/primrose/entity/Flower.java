package org.jboss.spring.examples.primrose.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Flower implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   private Long id;

   private String species;

   private String genus;

   private String location;

   @Enumerated(EnumType.STRING)
   private Watering watering;

   @Temporal(TemporalType.TIMESTAMP)
   private Date lastWatered;
   
   /**
    * @return the id
    */
   public Long getId()
   {
      return id;
   }

   /**
    * @param id the id to set
    */
   public void setId(Long id)
   {
      this.id = id;
   }

   /**
    * @return the species
    */
   public String getSpecies()
   {
      return species;
   }

   /**
    * @param species the species to set
    */
   public void setSpecies(String species)
   {
      this.species = species;
   }

   /**
    * @return the genus
    */
   public String getGenus()
   {
      return genus;
   }

   /**
    * @param genus the genus to set
    */
   public void setGenus(String genus)
   {
      this.genus = genus;
   }

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
    * @return the watering
    */
   public Watering getWatering()
   {
      return watering;
   }

   /**
    * @param watering the watering to set
    */
   public void setWatering(Watering watering)
   {
      this.watering = watering;
   }

   /**
    * @return the lastWatered
    */
   public Date getLastWatered()
   {
      return lastWatered;
   }

   /**
    * @param lastWatered the lastWatered to set
    */
   public void setLastWatered(Date lastWatered)
   {
      this.lastWatered = lastWatered;
   }

   
 

}
