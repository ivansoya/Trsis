package com.soya.trsis.carselling.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.soya.trsis.carselling.services.CustomerService;
/**
 *
 * @author manno
 */
@RestController
@RequestMapping("/public/rest/customers")
public class CustomerRestService {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> browse() {
        return ResponseEntity.ok(customerService.listAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") Integer id) {
        customerService.deleteById(id);
    }

    @RequestMapping(value = "/{name}/{position}/{salary}/{shop}", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@PathVariable("name") String name, @PathVariable("position") String position, 
                                      @PathVariable("salary") Integer salary, @PathVariable("shop") Integer shop) {
        return ResponseEntity.ok(customerService.add(name, position, salary, shop));
    }
   
}
