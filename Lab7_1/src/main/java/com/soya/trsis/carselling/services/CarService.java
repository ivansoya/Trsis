package com.soya.trsis.carselling.services;

import com.soya.trsis.carselling.db.model.Car;
/**
 *
 * @author manno
 */
public interface CarService {
    
    Iterable<Car> listAll();

    void delete(Car car);

    void deleteById(Integer id);

    Car add(Car car);
    
    Iterable<Car> findByShop(Integer shop);

    Car findById(Integer id);
}
