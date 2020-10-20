package com.soya.trsis.carselling.db.dao;

import com.soya.trsis.carselling.db.model.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author manno
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    public void deleteById(Integer id);

}
