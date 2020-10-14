package com.soya.trsis.carselling.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soya.trsis.carselling.db.dao.CarRepository;
import com.soya.trsis.carselling.db.model.Car;

/**
 *
 * @author manno
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Iterable<Car> listAll() {
        return carRepository.findAll();
    }

    @Override
    public void delete(Car car) {
        carRepository.delete(car);
    }

    @Override
    public Car add(Integer id, String model, Integer price, String company, Integer shop) {
        return carRepository.save(new Car(id, model, price, company, shop));
    }

    @Override
    public Iterable<Car> findByShop(Integer shop) {
        return carRepository.findByShop(shop);
    }

}
