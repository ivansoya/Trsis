package com.soya.trsis.carselling.db.dao;

import com.soya.trsis.carselling.db.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository 
        extends CrudRepository<User, Long>{

        User findByLogin(String login);

}
