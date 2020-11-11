package com.soya.trsis.carselling.services;

import com.soya.trsis.carselling.db.model.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class MyLogin extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 1L;

    private User user;

    public MyLogin(User user) {
        super(user.getLogin(), user.getHash(), AuthorityUtils.createAuthorityList("All"));
        this.user = user;
    }
}
