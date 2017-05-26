package com.mkyong.model;

import java.sql.*;

public class Employee {

    private int employeeId;
    private String name;
    private String username;
    private String genre;
    private String hireDate;
    private String password;

    public Employee()
    {

    }
    public Employee(int id,String name,String username,String genre,String hireDate,String pass)
    {
        this.employeeId=id;
        this.name=name;
        this.username=username;
        this.genre=genre;
        this.hireDate=hireDate;
        this.password=pass;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
            String statement = "SELECT `id_employee` FROM `employee` where `id_employee`=?";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setInt(1, id);
            ResultSet rs = dbStatement.executeQuery();
            while(rs.next()) {
                int id1 = rs.getInt("id_employee");
                if(id1==id)
                    return true;
                else return false;
            }
            return false;
        } catch (SQLException e) {

            System.out.println("Error occured reading Employees from the data source.");
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
            String statement = "SELECT `id_employee` FROM `employee` where `username`=?";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setString(1, user);
            ResultSet rs = dbStatement.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id_employee");
                if(id!=0)
                    return id;
                else return 0;
            }
            return 0;
        } catch (SQLException e) {

            System.out.println("Error occured reading Employees from the data source.");
            return 0;
        }
    }
    public boolean insert(int id, String name, String username, String genre, String hireDate, String password) {
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
            String statement = "INSERT INTO `employee` (`id_employee`,`name`, `username`, `genre`,`hire_date`) VALUES (?, ?, ?, ?,?)";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setInt(1, id);
            dbStatement.setString(2, name);
            dbStatement.setString(3, username);
            dbStatement.setString(4, genre);
            dbStatement.setString(5,hireDate);
            dbStatement.executeUpdate();

            String statement1 = "INSERT INTO `user` (`id_user`, `username`, `password`,`type`) VALUES (?, ?, ?, ?)";
            PreparedStatement dbStatement1 = conn.prepareStatement(statement1);
            dbStatement1.setInt(1, id+15);
            dbStatement1.setString(2, username);
            dbStatement1.setString(3, password);
            dbStatement1.setString(4, "employee");
            dbStatement1.executeUpdate();
            return true;

        } catch (SQLException e) {

            System.out.println("Error occured reading Employees from the data source.");
            return false;
        }
    }
    public boolean update(int id, String name, String username, String genre, String hireDate, String password) {
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
            String statement = "UPDATE `employee` SET `name`=?, `username`=?, `genre`=?,`hire_date`=?  where `id_employee`=?";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setString(1, name);
            dbStatement.setString(2, username);
            dbStatement.setString(3, genre);
            dbStatement.setString(4, hireDate);
            dbStatement.setInt(5, id);
            dbStatement.executeUpdate();

            String statement1 = "UPDATE `user` SET `username`=?, `password`=?,`type`=? where `id_user`=?";
            PreparedStatement dbStatement1 = conn.prepareStatement(statement1);
            dbStatement1.setString(1, username);
            dbStatement1.setString(2, password);
            dbStatement1.setString(3, "employee");
            dbStatement1.setInt(4, id+15);
            dbStatement1.executeUpdate();
            return true;

        } catch (SQLException e) {

            System.out.println("Error occured reading Employees from the data source.");
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
            String statement = "DELETE FROM employee where id_employee='"+id+"'";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.executeUpdate();
            int idUser=id+15;
            String statement1 = "DELETE FROM user where id_user='"+idUser+"'";
            PreparedStatement dbStatement1 = conn.prepareStatement(statement1);
            dbStatement1.executeUpdate();
            return true;

        } catch (SQLException e) {

            System.out.println("Error occured reading Employees from the data source.");
            return false;
        }
    }
}
