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
import com.soya.trsis.carselling.db.model.Car;

/**
 *
 * @author manno
 */
@Entity
@Table(name = "SHOP")
@Data
@AllArgsConstructor
public class Shop {

    public Shop() {
    }

    public Shop(String name, String town, String adress) {
        this.name = name;
        this.town = town;
        this.adress = adress;
    }

    @Id
    @Column(name = "SHOP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(targetEntity = Car.class, mappedBy = "shop" , fetch = FetchType.LAZY)
    private List<Car> carList;

    @OneToMany(targetEntity = Customer.class, mappedBy = "shop" , fetch = FetchType.LAZY)
    private List<Customer> customerList;

    @Column(name = "SHOP_NAME", unique=true)
    private String name;

    @Column(name = "SHOP_TOWN")
    private String town;

    @Column(name = "SHOP_ADRESS")
    private String adress;

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

//town
    public void setTown(String town) {
        this.town = town;
    }

    public String getTown() {
        return town;
    }

//price
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

//list
    public List<Car> getCarList() {
        return carList;
    }

//list2
    public List<Customer> getCustomerList() {
        return customerList;
    }

}
