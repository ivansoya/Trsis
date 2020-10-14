package com.soya.trsis.carselling.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soya.trsis.carselling.db.dao.CustomerRepository;
import com.soya.trsis.carselling.db.model.Customer;

/**
 *
 * @author manno
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> listAll() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer add(String name, String position, Integer salary, Integer shop) {
        return customerRepository.save(new Customer(name, position, salary, shop));
    }

}
