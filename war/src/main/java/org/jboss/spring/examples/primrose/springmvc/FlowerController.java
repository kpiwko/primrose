package org.jboss.spring.examples.primrose.springmvc;

import java.util.List;

import javax.ejb.EJB;

import org.jboss.spring.examples.primrose.ejb.FlowerService;
import org.jboss.spring.examples.primrose.entity.Flower;
import org.jboss.spring.examples.primrose.watering.WateringCan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FlowerController
{
   private static final Double CAN_VOLUME = 0.5d;

   @EJB(mappedName = "primrose/FlowerService")
   FlowerService flowerService;

   @Autowired
   WateringCan wateringCan;

   @RequestMapping(value = "/searchFlowers.do")
   ModelAndView getAllFlowers()
   {
      List<Flower> flowers = flowerService.getAllFlowers();

      ModelAndView model = new ModelAndView("listFlowers");
      model.addObject(flowers);
      return model;
   }

   @RequestMapping(value = "/flowerDetail.do")
   ModelAndView getFlowerDetail(@RequestParam("id") long id)
   {
      Flower flower = flowerService.find(id);

      ModelAndView model = new ModelAndView("flowerDetail");
      model.addObject(flower);
      return model;
   }

   @RequestMapping(value = "/waterNow.do")
   ModelAndView waterNow(@RequestParam("id") long id)
   {
      wateringCan.water(id, CAN_VOLUME);
      Flower flower = flowerService.find(id);

      ModelAndView model = new ModelAndView("flowerDetail");
      model.addObject(flower);
      return model;
   }

}
