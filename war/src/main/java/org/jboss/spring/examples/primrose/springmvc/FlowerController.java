package org.jboss.spring.examples.primrose.springmvc;

import java.util.List;

import javax.ejb.EJB;

import org.jboss.spring.examples.primrose.ejb.FlowerService;
import org.jboss.spring.examples.primrose.entity.Flower;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FlowerController
{
   @EJB(mappedName = "primrose/FlowerService")
   FlowerService flowerService;

   @RequestMapping(value = "/searchFlowers.do")
   ModelAndView getAllFlowers()
   {
      List<Flower> flowers = flowerService.getAllFlowers();

      ModelAndView model = new ModelAndView("listFlowers");
      model.addObject(flowers);
      return model;
   }

   @RequestMapping(value = "/flowerDetails.do")
   ModelAndView getFlowerDetail(@RequestParam("id") long id)
   {
      Flower flower = flowerService.find(id);

      ModelAndView model = new ModelAndView("listFlowers");
      model.addObject(flower);
      return model;
   }
}
