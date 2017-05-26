package com.mkyong.model;


import java.sql.*;

public class Contract {

    private int contractId;
    private String date;
    private int carId;
    private int customerId;
    private int employeeId;
    private String details;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Contract()
    {

    }
    public Contract(int cid,String d,int carid,int custid,int emplid)
    {
        this.contractId=cid;
        this.date=d;
        this.carId=carid;
        this.customerId=custid;
        this.employeeId=emplid;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public boolean updateParts(int customerId,String additionalParts) {
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
            String statement = "UPDATE `contract` SET `details`=?  where `id_customer`=?";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setString(1, additionalParts);
            dbStatement.setInt(2, customerId);
            dbStatement.executeUpdate();
            return true;

        } catch (SQLException e) {

            System.out.println("Error occured reading Contracts from the data source.");
            return false;
        }
    }
    public static boolean exists(int id)
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
            String statement = "SELECT `id_contract` FROM `contract` where `id_contract`=?";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setInt(1, id);
            ResultSet rs = dbStatement.executeQuery();
            while(rs.next()) {
                int id1 = rs.getInt("id_contract");
                if(id1==id)
                    return true;
                else return false;
            }
            return false;
        } catch (SQLException e) {

            System.out.println("Error occured reading Contracts from the data source.");
            return false;
        }
    }
    public boolean insert(int id, String date, int employeeId) {
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
            String statement = "INSERT INTO `contract` (`id_contract`,`date`, `id_car`, `id_customer`,`id_employee`) VALUES (?, ?, ?, ?,?)";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setInt(1, id);
            dbStatement.setString(2, date);
            dbStatement.setInt(3, 1);
            dbStatement.setInt(4, 1);
            dbStatement.setInt(5,employeeId);
            dbStatement.executeUpdate();
            return true;

        } catch (SQLException e) {

            System.out.println("Error occured reading Contracts from the data source.");
            return false;
        }
    }
    public boolean update(int id, String date, int carId,int customerId,int employeeId) {
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
            String statement = "UPDATE `contract` SET `date`=?, `id_car`=?, `id_customer`=?,`id_employee`=?  where `id_contract`=?";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setString(1, date);
            dbStatement.setInt(2, carId);
            dbStatement.setInt(3, customerId);
            dbStatement.setInt(4, employeeId);
            dbStatement.setInt(5, id);
            dbStatement.executeUpdate();
            return true;

        } catch (SQLException e) {

            System.out.println("Error occured reading Contracts from the data source.");
            return false;
        }
    }

}
