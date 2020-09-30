package com.soya.trsis.carselling.db.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author manno
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    public Customer() {
    }

    public Customer(String name, String position, Integer salary, Integer shop) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.shop = shop;
    }

    @Id
    @Column(name = "CUSTOMER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CUSTOMER_NAME", unique=true)
    private String name;

    @Column(name = "CUSTOMER_POSITION")
    private String position;

    @Column(name = "CUSTOMER_SALARY")
    private Integer salary;

    @Column(name = "CUSTOMER_SHOP")
    private Integer shop;

//id
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

//name
    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//position
    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

//salary
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getSalary() {
        return salary;
    }

//shop
    public void setShop(Integer shop) {
        this.shop = shop;
    }

    public Integer getShop() {
        return shop;
    }

}
