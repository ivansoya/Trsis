/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soya.trsis.carselling.model;

import java.util.*;
/**
 *
 * @author manno
 */
public  class NewModel {
    public static class Data {
        private String brand;
        private String model;
        private String cost;

        public Data(String brand, String model, String cost) {
            this.brand = brand;
            this.model = model;
            this.cost = cost;
        }
        
        public void setCarBrand(String brand) {
            this.brand = brand;
        }
        
        public void setCarModel(String model) {
            this.model = model;
        }

        public void setCarCost(String cost) {
            this.cost = cost;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public String getCost() {
            return cost;
        }
    }
    
    public static ArrayList<Data> base = new ArrayList<Data>();

    public static void add(String brand, String model, String cost) {
        Data data = new Data(brand, model, cost);
        base.add(data);
    }
 
}
