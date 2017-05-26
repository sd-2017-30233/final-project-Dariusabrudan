package com.mkyong.model;

import java.sql.*;

public class User {
    private int userId;
    private String username;
    private String password;
    private String type;

    public User()
    {

    }
    public User(int id, String us,String pass,String type)
    {
        this.userId=id;
        this.username=us;
        this.password=pass;
        this.type=type;
    }
    public User(String username)
    {
        this.username=username;
    }
    public User(int id)
    {
        this.userId=id;
    }
    public String getName1(int id)
    {
        if(this.userId==id)
            return this.username;
        else return "";
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "User [userId=" + userId+", username=" + username + ", password=" + password+ ", type=" + type + "]";
    }
    public static boolean isAdministrator(String user)
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
            conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            String statement = "SELECT `type` FROM `user` where `username`=?";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setString(1, user);
            ResultSet rs = dbStatement.executeQuery();

            while(rs.next()) {
                String type1 = rs.getString("type");
                if(type1.equals("administrator"))
                    return true;
                else return false;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Error occured reading Users from the data source.");
            return false;
        }
    }
    public static boolean isEmployee(String user)
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
            conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            String statement = "SELECT `type` FROM `user` where `username`=?";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setString(1, user);
            ResultSet rs = dbStatement.executeQuery();

            while(rs.next()) {
                String type1 = rs.getString("type");
                if(type1.equals("employee"))
                    return true;
                else return false;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Error occured reading Users from the data source.");
            return false;
        }
    }
    public static boolean isCustomer(String user)
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
            conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            String statement = "SELECT `type` FROM `user` where `username`=?";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setString(1, user);
            ResultSet rs = dbStatement.executeQuery();

            while(rs.next()) {
                String type1 = rs.getString("type");
                if(type1.equals("customer"))
                    return true;
                else return false;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Error occured reading Users from the data source.");
            return false;
        }
    }
    public static boolean checkPassword(String username,String pass)
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
            conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            String statement = "SELECT `password` FROM `user` where `username`=?";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setString(1, username);
            ResultSet rs = dbStatement.executeQuery();

            while(rs.next()) {
                String pass1 = rs.getString("password");
                if(pass1.equals(pass))
                    return true;
                else return false;
            }
            return false;
        } catch (SQLException e) {

            System.out.println("Error occured reading Users from the data source.");
            return false;
        }
    }
    public static boolean exists(String user)
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
            conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            String statement = "SELECT `id_user` FROM `user` where `username`=?";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setString(1, user);
            ResultSet rs = dbStatement.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id_user");
                if(id!=0)
                    return true;
                else return false;
            }
            return false;
        } catch (SQLException e) {

            System.out.println("Error occured reading Users from the data source.");
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
            String statement = "SELECT `id_user` FROM `user` where `username`=?";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setString(1, user);
            ResultSet rs = dbStatement.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id_user");
                if(id!=0)
                    return id;
                else return 0;
            }
            return 0;
        } catch (SQLException e) {

            System.out.println("Error occured reading Users from the data source.");
            return 0;
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
            conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            String statement = "SELECT `id_user` FROM `user` where `id_user`=?";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setInt(1, id);
            ResultSet rs = dbStatement.executeQuery();
            while(rs.next()) {
                int id1 = rs.getInt("id_user");
                if(id1==id)
                    return true;
                else return false;
            }
            return false;
        } catch (SQLException e) {

            System.out.println("Error occured reading Users from the data source.");
            return false;
        }
    }
    public boolean insert(int id,String username, String pass,String type) {
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
            String statement = "INSERT INTO `user` (`id_user`, `username`, `password`,`type`) VALUES (?, ?, ?, ?)";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setInt(1, id);
            dbStatement.setString(2, username);
            dbStatement.setString(3, pass);
            dbStatement.setString(4, type);
            dbStatement.executeUpdate();
            return true;

        } catch (SQLException e) {

            System.out.println("Error occured reading Users from the data source.");
            return false;
        }
    }
    public boolean update(int id,String username, String pass,String type) {
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
            String statement = "UPDATE `user` SET `username`=?, `password`=?,`type`=? where `id_user`=?";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setString(1, username);
            dbStatement.setString(2, pass);
            dbStatement.setString(3, type);
            dbStatement.setInt(4, id);
            dbStatement.executeUpdate();
            return true;

        } catch (SQLException e) {

            System.out.println("Error occured reading Users from the data source.");
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
            String statement = "DELETE FROM user where id_user='"+id+"'";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.executeUpdate();
            return true;

        } catch (SQLException e) {

            System.out.println("Error occured reading Users from the data source.");
            return false;
        }
    }
    public String getNameId(int id)
    {
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
            String statement = "SELECT `username` FROM `user` where `id_user`=?";
            PreparedStatement dbStatement = conn.prepareStatement(statement);
            dbStatement.setInt(1, id);
            ResultSet rs = dbStatement.executeQuery();
            while(rs.next()) {
                String username = rs.getString("username");
                return username;
            }
            return null;
        } catch (SQLException e) {

            System.out.println("Error occured reading Users from the data source.");
            return null;
        }
    }
}

