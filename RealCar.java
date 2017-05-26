package com.mkyong.model;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.List;

public class RealCar implements ICar {

    private int carId;
    private String make;
    private String model;
    private int year;
    private int horsePower ;
    private float fuelConsumption;
    private float price;
    private BufferedImage image;

        public RealCar()
        {

        }

        public BufferedImage getImage() {
            return image;
        }

        public void setImage(BufferedImage image) {
            this.image = image;
        }

        public RealCar(int id, String make, String model, int year, int horsePower, float fuelConsumption, float price)
        {
            this.carId=id;
            this.make=make;
            this.model=model;
            this.year=year;
            this.horsePower=horsePower;
            this.fuelConsumption=fuelConsumption;
            this.price=price;
            try {
                this.image = ImageIO.read(new File(make +model+ ".png"));
            } catch (IOException ex) {
                // handle exception...
            }
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
        public boolean exists(int id)
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Where is your MySQL JDBC Driver?");
                e.printStackTrace();
                return false;
            }
            try {
                Connection conn=null;
                conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
                String statement = "SELECT `id_car` FROM `car` where `id_car`=?";
                PreparedStatement dbStatement = conn.prepareStatement(statement);
                dbStatement.setInt(1, id);
                ResultSet rs = dbStatement.executeQuery();
                while(rs.next()) {
                    int id1 = rs.getInt("id_car");
                    if(id1==id)
                        return true;
                    else return false;
                }
                return false;
            } catch (SQLException e) {

                System.out.println("Error occured reading Cars from the data source.");
                return false;
            }
        }
        public boolean insert(int id, String make, String model, int year,int horsePower,float fuelConsumption,float price) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Where is your MySQL JDBC Driver?");
                e.printStackTrace();
                return false;
            }
            try {
                Connection conn=null;
                conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
                String statement = "INSERT INTO `car` (`id_car`,`make`, `model`, `year`,`horse_power`,`fuel_consumption`,`price`) VALUES (?, ?, ?, ?,?,?,?)";
                PreparedStatement dbStatement = conn.prepareStatement(statement);
                dbStatement.setInt(1, id);
                dbStatement.setString(2, make);
                dbStatement.setString(3, model);
                dbStatement.setInt(4, year);
                dbStatement.setInt(5,horsePower);
                dbStatement.setFloat(6,fuelConsumption);
                dbStatement.setFloat(7,price);
                dbStatement.executeUpdate();
                return true;

            } catch (SQLException e) {

                System.out.println("Error occured reading Cars from the data source.");
                return false;
            }
        }
        public boolean update(int id, String make, String model, int year,int horsePower,float fuelConsumption,float price) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Where is your MySQL JDBC Driver?");
                e.printStackTrace();
                return false;
            }
            try {
                Connection conn=null;
                conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
                String statement = "UPDATE `car` SET `make`=?, `model`=?, `year`=?,`horse_power`=?,`fuel_consumption`=?,`price`=?  where `id_car`=?";
                PreparedStatement dbStatement = conn.prepareStatement(statement);
                dbStatement.setString(1, make);
                dbStatement.setString(2, model);
                dbStatement.setInt(3, year);
                dbStatement.setInt(4, horsePower);
                dbStatement.setFloat(5,fuelConsumption);
                dbStatement.setFloat(6,price);
                dbStatement.setInt(7, id);
                dbStatement.executeUpdate();
                return true;

            } catch (SQLException e) {

                System.out.println("Error occured reading Cars from the data source.");
                return false;
            }
        }

        public boolean delete(int id) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Where is your MySQL JDBC Driver?");
                e.printStackTrace();
                return false;
            }
            try {
                Connection conn=null;
                conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
                String statement = "DELETE FROM car where id_car='"+id+"'";
                PreparedStatement dbStatement = conn.prepareStatement(statement);
                dbStatement.executeUpdate();
                return true;

            } catch (SQLException e) {

                System.out.println("Error occured reading Cars from the data source.");
                return false;
            }
        }
        public static DefaultTableModel buildTableModel(ResultSet rs)
                throws SQLException {

            ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();

            // names of columns
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(metaData.getColumnName(column));
            }

            // data of the table
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);
            }

            return new DefaultTableModel(data, columnNames);

        }
        public boolean viewCars() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Where is your MySQL JDBC Driver?");
                e.printStackTrace();
                return false;
            }
            try {
                Connection conn=null;
                conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
                String statement = "Select * FROM `car`";
                PreparedStatement dbStatement = conn.prepareStatement(statement);
                ResultSet rs = dbStatement.executeQuery();

                // It creates and displays the table
                JTable table = new JTable(buildTableModel(rs));
                table.setPreferredScrollableViewportSize(new Dimension(800,400));
                // Closes the Connection
                JOptionPane.showMessageDialog(null, new JScrollPane(table));
                return true;

            } catch (SQLException e) {

                System.out.println("Error occured reading Cars from the data source.");
                return false;
            }
        }
        public boolean searchByMake(String make,String model) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Where is your MySQL JDBC Driver?");
                e.printStackTrace();
                return false;
            }
            try {
                Connection conn=null;
                conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
                String statement = "Select * FROM `car` where `make`=? and `model`=?";
                PreparedStatement dbStatement = conn.prepareStatement(statement);
                dbStatement.setString(1, make);
                dbStatement.setString(2, model);
                ResultSet rs = dbStatement.executeQuery();

                // It creates and displays the table
                JTable table = new JTable(buildTableModel(rs));
                table.setPreferredScrollableViewportSize(new Dimension(800,400));
                // Closes the Connection
                JOptionPane.showMessageDialog(null, new JScrollPane(table));
                return true;

            } catch (SQLException e) {

                System.out.println("Error occured reading Cars from the data source.");
                return false;
            }
        }
        public List<ProxyCar> getAllCars() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Where is your MySQL JDBC Driver?");
                e.printStackTrace();
                return null;
            }
            try {
                Connection conn=null;
                conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
                String statement = "Select * FROM `car`";
                PreparedStatement dbStatement = conn.prepareStatement(statement);
                ResultSet rs = dbStatement.executeQuery();
                List<ProxyCar> cars=new ArrayList<ProxyCar>();
                while (rs.next()) {
                    //Retrieve by column name
                    int id = rs.getInt("id_car");
                    String make = rs.getString("make");
                    String model = rs.getString("model");
                    int year=rs.getInt("year");
                    int horsepower=rs.getInt("horse_power");
                    float fuel=rs.getFloat("fuel_consumption");
                    float price =rs.getFloat("price");

                    ProxyCar c = new ProxyCar(id,make,model,year,horsepower,fuel,price);
                    cars.add(c);
                }
                return cars;
            } catch (SQLException e) {

                System.out.println("Error occured reading Cars from the data source.");
                return null;
            }
        }
}
