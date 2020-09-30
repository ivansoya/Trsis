package com.soya.trsis.carselling.services;

import com.soya.trsis.carselling.db.model.Shop;
/**
 *
 * @author manno
 */
public interface ShopService {
    
    Iterable<Shop> listAll();

    void deleteById(Integer id);
    
    Shop add(String name, String town, String adress);
    
    Shop findByName(String name);
}
