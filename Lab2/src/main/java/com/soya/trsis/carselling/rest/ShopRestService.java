package com.soya.trsis.carselling.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.soya.trsis.carselling.services.ShopService;
/**
 *
 * @author manno
 */
@RestController
@RequestMapping("/public/rest/shops")
public class ShopRestService {

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> browse() {
        return ResponseEntity.ok(shopService.listAll());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable("id") Integer id) {
        shopService.deleteById(id);
    }

    @RequestMapping(value = "/{name}/{town}/{adress}", method = RequestMethod.GET)
    public ResponseEntity<Object> add(@PathVariable("name") String name, @PathVariable("town") String town, 
                                      @PathVariable("adress") String adress){
        return ResponseEntity.ok(shopService.add(name, town, adress));
    }
    
    @RequestMapping(value = "/find/{name}", method = RequestMethod.GET)
    public ResponseEntity<Object> findByShop(@PathVariable("name") String name) {
        return ResponseEntity.ok(shopService.findByName(name));
    }
}