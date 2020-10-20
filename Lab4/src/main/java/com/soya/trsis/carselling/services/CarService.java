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
    
    Car add(Integer id, String model, Integer price, String company, Integer shop);
    
    Iterable<Car> findByShop(Integer shop);

    Car findById(Integer id);
}
