package com.soya.trsis.carselling.db.dao;

import com.soya.trsis.carselling.db.model.Car;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author manno
 */
public interface CarRepository extends CrudRepository<Car, Integer> {

    public Iterable<Car> findByShop(Integer shop);

}
