package com.mkyong.model;

import java.sql.*;

public class Customer {

    private int customerId;
    private String name;
    private String username;
    private int identityCardNumber;
    private String cnp;
    private String address;
    private String password;

    public Customer(){

    }
    public Customer(int id,String name,String username,int icn,String cnp,String address,String pass)
    {
        this.customerId=id;
        this.name=name;
        this.username=username;
        this.identityCardNumber=icn;
        this.cnp=cnp;
        this.address=address;
        this.password=pass;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int cusotmerId) {
        this.customerId = cusotmerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(int identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
            String statement = "SELECT `id_customer` FROM `customer` where `id_customer`=?";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setInt(1, id);
            ResultSet rs = dbStatement.executeQuery();
            while(rs.next()) {
                int id1 = rs.getInt("id_customer");
                if(id1==id)
                    return true;
                else return false;
            }
            return false;
        } catch (SQLException e) {

            System.out.println("Error occured reading Customers from the data source.");
            return false;
        }
    }
    public static int getId (String user)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return 0;
        }
        try {
            Connection conn=null;
            conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            String statement = "SELECT `id_cutomer` FROM `customer` where `username`=?";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setString(1, user);
            ResultSet rs = dbStatement.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id_customer");
                if(id!=0)
                    return id;
                else return 0;
            }
            return 0;
        } catch (SQLException e) {

            System.out.println("Error occured reading Customers from the data source.");
            return 0;
        }
    }
    public boolean insert(int id,String name,String username,int identityCardNumber,String cnp,String address,String password) {
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
            String statement = "INSERT INTO `customer` (`id_customer`,`name`, `username`, `identity_card_number`,`personal_numerical_code`,`address`) VALUES (?, ?, ?, ?,?,?)";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setInt(1, id);
            dbStatement.setString(2, name);
            dbStatement.setString(3, username);
            dbStatement.setInt(4, identityCardNumber);
            dbStatement.setString(5, cnp);
            dbStatement.setString(6, address);
            dbStatement.executeUpdate();

            String statement1 = "INSERT INTO `user` (`id_user`, `username`, `password`,`type`) VALUES (?, ?, ?, ?)";
            PreparedStatement dbStatement1 = conn.prepareStatement(statement1);
            dbStatement1.setInt(1, id+5);
            dbStatement1.setString(2, username);
            dbStatement1.setString(3, password);
            dbStatement1.setString(4, "customer");
            dbStatement1.executeUpdate();
            return true;

        } catch (SQLException e) {

            System.out.println("Error occured reading Customers from the data source.");
            return false;
        }
    }
    public boolean update(int id,String name,String username,int identityCardNumber,String cnp,String address,String pass) {
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
            String statement = "UPDATE `customer` SET `name`=?, `username`=?, `identity_card_number`=?,`personal_numerical_code`=?,`address`=? where `id_customer`=?";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setString(1, name);
            dbStatement.setString(2, username);
            dbStatement.setInt(3, identityCardNumber);
            dbStatement.setString(4, cnp);
            dbStatement.setString(5, address);
            dbStatement.setInt(6, id);
            dbStatement.executeUpdate();

            String statement1 = "UPDATE `user` SET `username`=?, `password`=?,`type`=? where `id_user`=?";
            PreparedStatement dbStatement1 = conn.prepareStatement(statement1);
            dbStatement1.setString(1, username);
            dbStatement1.setString(2, pass);
            dbStatement1.setString(3, "customer");
            dbStatement1.setInt(4, id+5);
            dbStatement1.executeUpdate();
            return true;

        } catch (SQLException e) {

            System.out.println("Error occured reading Customers from the data source.");
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
            String statement = "DELETE FROM customer where id_customer='"+id+"'";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.executeUpdate();
            int idUser=id+5;
            String statement1 = "DELETE FROM user where id_user='"+idUser+"'";
            PreparedStatement dbStatement1 = conn.prepareStatement(statement1);
            dbStatement1.executeUpdate();
            return true;

        } catch (SQLException e) {

            System.out.println("Error occured reading Customers from the data source.");
            return false;
        }
    }
}
