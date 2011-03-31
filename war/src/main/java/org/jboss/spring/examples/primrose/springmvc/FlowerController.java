package org.jboss.spring.examples.primrose.springmvc;

import java.util.List;

import javax.ejb.EJB;

import org.jboss.spring.examples.primrose.dta.Flower;
import org.jboss.spring.examples.primrose.ejb.FlowerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FlowerController
{
   @EJB(mappedName = "primrose/FlowerService")
   FlowerService flowerService;

   @RequestMapping(value = "/searchFlowers.do")
   ModelMap getAllFlowers()
   {
      List<Flower> flowers = flowerService.getAllFlowers();

      ModelMap map = new ModelMap();
      map.addAttribute(flowers);
      return map;
   }

   @RequestMapping(value = "/flowerDetails.do")
   ModelMap getFlowerDetail(@RequestParam("id") long id)
   {
      Flower flower = flowerService.find(id);

      ModelMap map = new ModelMap();
      map.addAttribute(flower);
      return map;
   }
}
