package com.mkyong.model;

import java.util.List;

public interface ICar {
    public boolean exists(int id);
    public boolean insert(int id, String make, String model, int year,int horsePower,float fuelConsumption,float price);
    public boolean update(int id, String make, String model, int year,int horsePower,float fuelConsumption,float price);
    public boolean delete(int id);
    public boolean viewCars();
    public boolean searchByMake(String make,String model);
    public List<ProxyCar> getAllCars();
}
