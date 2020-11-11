/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soya.trsis.carselling.db.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {

    public User() {
    }

    public User(String login, String hash) {
        this.login = login;
        this.hash = hash;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false, updatable = false)
    private Long id;
    
    @Column(name = "USER_LOGIN", nullable = false, unique = true)
    private String login;

    @Column(name = "USER_HASH", nullable = false, unique = true)
    private String hash;

    //id
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    //login
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    //hash
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

}

