package com.soya.trsis.carselling.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soya.trsis.carselling.db.dao.ShopRepository;
import com.soya.trsis.carselling.db.model.Shop;

/**
 *
 * @author manno
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public Iterable<Shop> listAll() {
        return shopRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        shopRepository.deleteById(id);
    }

    @Override
    public Shop add(String name, String town, String adress) {
        return shopRepository.save(new Shop(name, town, adress));
    }

    @Override
    public Shop findByName(String name) {
        return shopRepository.findByName(name);
    }

    @Override
    public Shop findById(Integer id) {
        return shopRepository.findById(id).orElse(null);
    }

}
