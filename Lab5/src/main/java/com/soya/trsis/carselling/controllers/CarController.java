package com.soya.trsis.carselling.controllers;

import com.soya.trsis.carselling.services.CarService;
import com.soya.trsis.carselling.db.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.soya.trsis.carselling.rest.ForbiddenException;

import java.security.Principal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@Controller
public class CarController {

    @Autowired
    CarService carService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView cars() {
        ModelAndView mav = new ModelAndView("cars");
        mav.addObject("cars", carService.listAll());
        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView addCar(@ModelAttribute("carID") Integer id, @ModelAttribute("carModel") String model,
                       @ModelAttribute("carShop") Integer shop, @ModelAttribute("carPrice") Integer price,
                       @ModelAttribute("carCompany") String company) {
        carService.add(id, model, price, company, shop);
        ModelAndView mav = new ModelAndView("cars");
        mav.addObject("cars", carService.listAll());
        return mav;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCar(@ModelAttribute("carDelete") Integer id) {
        carService.deleteById(id);
        return "redirect:/";
    }

}
