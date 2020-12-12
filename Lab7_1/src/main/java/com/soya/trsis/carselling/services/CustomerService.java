package com.soya.trsis.carselling.services;

import com.soya.trsis.carselling.db.model.Customer;
/**
 *
 * @author manno
 */
public interface CustomerService {
    
    Iterable<Customer> listAll();

    void deleteById(Integer id);
    
    Customer add(String name, String position, Integer salary, Integer shop);
   
}
