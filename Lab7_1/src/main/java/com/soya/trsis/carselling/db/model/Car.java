package com.soya.trsis.carselling.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author manno
 */
@Entity
@Table(name = "CAR")
public class Car {

    public Car() {
    }

    public Car(Integer id, String model, Integer price, String company, Integer shop) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.company = company;
        this.shop = shop;
    }

    @Id
    @Column(name = "CAR_ID")
    private Integer id;

    @Column(name = "CAR_MODEL")
    private String model;

    @Column(name = "CAR_SHOP_ID")
    private Integer shop;

    @Column(name = "CAR_PRICE")
    private Integer price;

    @Column(name = "CAR_COMPANY")
    private String company;

//id
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

//model
    public void setModel (String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

//shop
    public void setShop(Integer shop) {
        this.shop = shop;
    }

    public Integer getShop() {
        return shop;
    }

//price
    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

//company
    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

}
