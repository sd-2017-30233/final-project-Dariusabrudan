package com.mkyong.model;

import java.util.ArrayList;
import java.util.List;

public class PriceCriteria implements Criteria {

    private float price;
    public PriceCriteria(float price)
    {
        this.price=price;
    }
    @Override
    public List<ProxyCar> meetCriteria(List<ProxyCar> cars) {
        List<ProxyCar> priceCars = new ArrayList<ProxyCar>();

        for (ProxyCar car : cars) {
            if(car.getPrice()<=price){
                priceCars.add(car);
            }
        }
        return priceCars;
    }
}
