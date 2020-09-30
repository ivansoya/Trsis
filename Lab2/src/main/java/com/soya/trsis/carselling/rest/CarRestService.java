package com.soya.trsis.carselling.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.soya.trsis.carselling.services.CarService;
/**
 *
 * @author manno
 */
@RestController
@RequestMapping("/public/rest/cars")
public class CarRestService {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> browse() {
        return ResponseEntity.ok(carService.listAll());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable("id") Integer id) {
        carService.deleteById(id);
    }

    @RequestMapping(value = "/{id}/{model}/{price}/{company}/{shop}", method = RequestMethod.GET)
    public ResponseEntity<Object> add(@PathVariable("id") Integer id, @PathVariable("model") String model, 
                                      @PathVariable("price") Integer price, @PathVariable("company") String company,
                                      @PathVariable("shop") Integer shop) {
        return ResponseEntity.ok(carService.add(id, model, price, company, shop));
    }
    
    @RequestMapping(value = "/find/{shop}", method = RequestMethod.GET)
    public ResponseEntity<Object> findByShop(@PathVariable("shop") Integer shop) {
        return ResponseEntity.ok(carService.findByShop(shop));
    }
}
