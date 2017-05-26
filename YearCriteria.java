package com.mkyong.model;

import java.util.ArrayList;
import java.util.List;

public class YearCriteria implements Criteria {

        private int year;
        public YearCriteria(int year)
        {
            this.year=year;
        }
        @Override
        public List<ProxyCar> meetCriteria(List<ProxyCar> cars) {
            List<ProxyCar> yearCars = new ArrayList<ProxyCar>();

            for (ProxyCar car : cars) {
                if(car.getYear()>=year){
                   yearCars.add(car);
                }
            }
            return yearCars;
        }
}
