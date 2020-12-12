package com.soya.trsis.carselling.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.soya.trsis.carselling.kafka.Producer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.soya.trsis.carselling.services.CarService;
import com.soya.trsis.carselling.db.model.Car;
import com.soya.trsis.carselling.rest.ForbiddenException;
import org.springframework.kafka.core.KafkaTemplate;

import java.security.Principal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 *
 * @author manno
 */
@RestController
@RequestMapping("/public/rest/cars")
public class CarRestService {

    @Autowired
    Producer producer;

    @Autowired
    private CarService carService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> browse() {
        String[] password = new String[] {"blabla", "testing", "12g34gh", "myPasswod"};
        for (int i = 0; i < password.length; i++) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(password[i]);

            System.out.println(hashedPassword);
        }   
        return ResponseEntity.ok(carService.listAll());
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@RequestBody Car car, @AuthenticationPrincipal Principal principal) {
        if (principal == null)
            throw new ForbiddenException();
        carService.delete(car);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> add(@RequestBody Car car, @AuthenticationPrincipal Principal principal) {
        if (principal == null)
           throw new ForbiddenException();
        Car added = carService.add(car);
        try{
            producer.sendMessage(car);
        }
        catch(Exception e){
            return null;
        }
        return ResponseEntity.ok(added);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void add(@PathVariable("id") Integer id, @AuthenticationPrincipal Principal principal) {
        if (principal == null)
            throw new ForbiddenException();
        carService.deleteById(id);
    }
    
    @RequestMapping(value = "/{shop}", method = RequestMethod.POST)
    public ResponseEntity<Object> findByShop(@PathVariable("shop") Integer shop, @AuthenticationPrincipal Principal principal) {
        if (principal == null)
            throw new ForbiddenException();
        return ResponseEntity.ok(carService.findByShop(shop));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(carService.findById(id));
    }
}
