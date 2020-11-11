package com.soya.trsis.carselling.db.dao;

import com.soya.trsis.carselling.db.model.Shop;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author manno
 */
public interface ShopRepository extends CrudRepository<Shop, Integer> {

    public void deleteById(Integer id);

    public Shop findByName(String name);

}
