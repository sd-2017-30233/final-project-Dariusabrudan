package com.mkyong.model;

import java.awt.image.BufferedImage;
import java.util.List;

public class ProxyCar implements ICar{

        private int carId;
        private String make;
        private String model;
        private int year;
        private int horsePower ;
        private float fuelConsumption;
        private float price;
        private BufferedImage image;
        private RealCar realCar;

        public ProxyCar()
        {

        }

        public BufferedImage getImage() {
            return image;
        }

        public void setImage(BufferedImage image) {
            this.image = image;
        }

        public ProxyCar(int id, String make, String model, int year, int horsePower, float fuelConsumption, float price)
        {
            this.carId=id;
            this.make=make;
            this.model=model;
            this.year=year;
            this.horsePower=horsePower;
            this.fuelConsumption=fuelConsumption;
            this.price=price;
        }
        @Override
        public String toString() {
            return "Car [carId=" + carId+", make=" + make + ", model=" + model+ ", year=" + year + ", horsepower=" + horsePower+ ", fuelConsumption=" + fuelConsumption+ ", price=" + price+ "]";
        }
        public float getFuelConsumption() {
            return fuelConsumption;
        }

        public void setFuelConsumption(float fuelConsumption) {
            this.fuelConsumption = fuelConsumption;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public int getCarId() {

            return carId;
        }

        public void setCarId(int carId) {
            this.carId = carId;
        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getHorsePower() {
            return horsePower;
        }

        public void setHorsePower(int horsePower) {
            this.horsePower = horsePower;
        }
        public boolean exists(int id) {
            if (realCar == null) {
                realCar = new RealCar();
            }
            return realCar.exists(id);
        }
        public boolean insert(int id, String make, String model, int year,int horsePower,float fuelConsumption,float price) {
            if (realCar == null) {
                realCar = new RealCar(id, make, model, year, horsePower, fuelConsumption, price);
            }
            return realCar.insert(id, make, model, year, horsePower, fuelConsumption, price);
        }
        public boolean update(int id, String make, String model, int year,int horsePower,float fuelConsumption,float price) {
            if (realCar == null) {
                realCar = new RealCar(id, make, model, year, horsePower, fuelConsumption, price);
            }
            return realCar.update(id, make, model, year, horsePower, fuelConsumption, price);
        }

        public boolean delete(int id) {
            if (realCar == null) {
                realCar = new RealCar(id, make, model, year, horsePower, fuelConsumption, price);
            }
            return realCar.delete(id);
        }
        public boolean viewCars() {
            if (realCar == null) {
                realCar = new RealCar();
            }
            return realCar.viewCars();
        }
        public boolean searchByMake(String make,String model) {
            if (realCar == null) {
                realCar = new RealCar();
            }
            return realCar.searchByMake(make, model);
        }
        public List<ProxyCar> getAllCars() {
            if (realCar == null) {
                realCar = new RealCar();
            }
            return realCar.getAllCars();
        }
}

