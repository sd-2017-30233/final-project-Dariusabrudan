package com.mkyong.client;

import com.mkyong.model.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AdministratorFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;
    private JTextField textField_14;
    private JTextField textField_15;
    private JTextField textField_16;


    public AdministratorFrame() {
        super("Administrator user");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 204, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnInsertCustomer = new JButton("Insert Cusotmer");
        btnInsertCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if (textField.getText().equals("") || !Pattern.matches("[0-9]+", textField.getText()))
                    JOptionPane.showMessageDialog(null, "Invalid customer id");
                else if (textField_1.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid name");
                else if (textField_2.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid username");
                else if (textField_3.getText().equals("")|| !Pattern.matches("[0-9]+", textField_3.getText()))
                    JOptionPane.showMessageDialog(null, "Invalid identity card number");
                else if (textField_4.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid CNP");
                else if (textField_5.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid address");
                else if (textField_6.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid password");
                else {
                    int id = Integer.parseInt(textField.getText());
                    String name=textField_1.getText();
                    String username = textField_2.getText();
                    int icn = Integer.parseInt(textField_3.getText());
                    String cnp = textField_4.getText();
                    String address=textField_5.getText();
                    String pass=textField_6.getText();
                    Customer c=new Customer(id,name,username,icn,cnp,address,pass);
                    String input = "{\"customerId\":\"" + id + "\",\"name\":\"" + name + "\","
                            + " \"username\":\"" + username + "\","
                            + " \"identityCardNumber\":\"" + icn + "\","
                            + " \"cnp\":\"" + cnp + "\","
                            + " \"address\":\"" + address + "\","
                            + " \"password\":\"" + pass + "\"}";
                    String url = "http://localhost:8080/rest/customer";
                    if (cmd.equals("Open")) {
                        jsonSendUser(input, url);
                    }
                }
            }
        });
        btnInsertCustomer.setBounds(47, 54, 150, 32);
        btnInsertCustomer.setActionCommand("Open");
        contentPane.add(btnInsertCustomer);

        JButton btnNewButton = new JButton("Update customer");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if (textField.getText().equals("") || !Pattern.matches("[0-9]+", textField.getText()))
                    JOptionPane.showMessageDialog(null, "Invalid customer id");
                else if (textField_1.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid name");
                else if (textField_2.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid username");
                else if (textField_3.getText().equals("")|| !Pattern.matches("[0-9]+", textField_3.getText()))
                    JOptionPane.showMessageDialog(null, "Invalid identity card number");
                else if (textField_4.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid CNP");
                else if (textField_5.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid address");
                else if (textField_6.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid password");
                else {
                    int id = Integer.parseInt(textField.getText());
                    String name=textField_1.getText();
                    String username = textField_2.getText();
                    int icn = Integer.parseInt(textField_3.getText());
                    String cnp = textField_4.getText();
                    String address=textField_5.getText();
                    String pass=textField_6.getText();
                    Customer c=new Customer(id,name,username,icn,cnp,address,pass);
                    String input = "{\"customerId\":\"" + id + "\",\"name\":\"" + name + "\","
                            + " \"username\":\"" + username + "\","
                            + " \"identityCardNumber\":\"" + icn + "\","
                            + " \"cnp\":\"" + cnp + "\","
                            + " \"address\":\"" + address + "\","
                            + " \"password\":\"" + pass + "\"}";
                    String url = "http://localhost:8080/rest/customer";
                    if (cmd.equals("Open")) {
                        jsonSendUser1(input, url);
                    }
                }
            }
        });
        btnNewButton.setBounds(47, 97, 150, 32);
        btnNewButton.setActionCommand("Open");
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Delete customer");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if (textField.getText().equals("") || !Pattern.matches("[0-9]+", textField.getText()))
                    JOptionPane.showMessageDialog(null, "Invalid customer id");
                else {
                    int id = Integer.parseInt(textField.getText());
                    String input = "{\"customerId\":\"" + id + "\"}";
                    String url = "http://localhost:8080/rest/customer";
                    if (cmd.equals("Open")) {
                        jsonSendUser2(input, url);
                    }
                }
            }
        });
        btnNewButton_1.setBounds(47, 140, 150, 32);
        btnNewButton_1.setActionCommand("Open");
        contentPane.add(btnNewButton_1);

        JButton btnInsertEmployee = new JButton("Insert Employee");
        btnInsertEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if (textField_7.getText().equals("") || !Pattern.matches("[0-9]+", textField_7.getText()))
                    JOptionPane.showMessageDialog(null, "Invalid employee id");
                else if (textField_1.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid name");
                else if (textField_2.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid username");
                else if (textField_8.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid genre");
                else if (textField_9.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid hire date");
                else if (textField_6.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid password");
                else {
                    int id = Integer.parseInt(textField_7.getText());
                    String name=textField_1.getText();
                    String username = textField_2.getText();
                    String genre = textField_8.getText();
                    String date=textField_9.getText();
                    String pass=textField_6.getText();
                    Employee em=new Employee(id,name,username,genre,date,pass);
                    String input = "{\"employeeId\":\"" + id + "\",\"name\":\"" + name + "\","
                            + " \"username\":\"" + username + "\","
                            + " \"genre\":\"" + genre + "\","
                            + " \"hireDate\":\"" + date + "\","
                            + " \"password\":\"" + pass + "\"}";
                    String url = "http://localhost:8080/rest/employee";
                    if (cmd.equals("Open")) {
                        jsonSendUser(input, url);
                    }
                }
            }
        });
        btnInsertEmployee.setBounds(47, 183, 150, 32);
        btnInsertEmployee.setActionCommand("Open");
        contentPane.add(btnInsertEmployee);

        JButton btnNewButton1 = new JButton("Update employee");
        btnNewButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if (textField_7.getText().equals("") || !Pattern.matches("[0-9]+", textField_7.getText()))
                    JOptionPane.showMessageDialog(null, "Invalid employee id");
                else if (textField_1.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid name");
                else if (textField_2.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid username");
                else if (textField_8.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid genre");
                else if (textField_9.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid hire date");
                else if (textField_6.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid password");
                else {
                    int id = Integer.parseInt(textField_7.getText());
                    String name=textField_1.getText();
                    String username = textField_2.getText();
                    String genre = textField_8.getText();
                    String date=textField_9.getText();
                    String pass=textField_6.getText();
                    Employee em=new Employee(id,name,username,genre,date,pass);
                    String input = "{\"employeeId\":\"" + id + "\",\"name\":\"" + name + "\","
                            + " \"username\":\"" + username + "\","
                            + " \"genre\":\"" + genre + "\","
                            + " \"hireDate\":\"" + date + "\","
                            + " \"password\":\"" + pass + "\"}";
                    String url = "http://localhost:8080/rest/employee";
                    if (cmd.equals("Open")) {
                        jsonSendUser1(input, url);
                    }
                }
            }
        });
        btnNewButton1.setBounds(47, 226, 150, 32);
        btnNewButton1.setActionCommand("Open");
        contentPane.add(btnNewButton1);

        JButton btnNewButton_11 = new JButton("Delete employee");
        btnNewButton_11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if (textField_7.getText().equals("") || !Pattern.matches("[0-9]+", textField_7.getText()))
                    JOptionPane.showMessageDialog(null, "Invalid employee id");
                else {
                    int id = Integer.parseInt(textField_7.getText());
                    String input = "{\"employeeId\":\"" + id + "\"}";
                    String url = "http://localhost:8080/rest/employee";
                    if (cmd.equals("Open")) {
                        jsonSendUser2(input, url);
                    }
                }
            }
        });
        btnNewButton_11.setBounds(47, 269, 150, 32);
        btnNewButton_11.setActionCommand("Open");
        contentPane.add(btnNewButton_11);

        JButton btnInsertCar = new JButton("Insert Car");
        btnInsertCar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if (textField_10.getText().equals("") || !Pattern.matches("[0-9]+", textField_10.getText()))
                    JOptionPane.showMessageDialog(null, "Invalid car id");
                else if (textField_11.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid make");
                else if (textField_12.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid model");
                else if (textField_13.getText().equals("") || !Pattern.matches("[0-9]+", textField_13.getText()))
                    JOptionPane.showMessageDialog(null, "Invalid year");
                else if (textField_14.getText().equals("") || !Pattern.matches("[0-9]+", textField_14.getText()))
                    JOptionPane.showMessageDialog(null, "Invalid horse power");
                else if (textField_15.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid fuel consumption");
                else if (textField_16.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid price");
                else {
                    int id = Integer.parseInt(textField_10.getText());
                    String make=textField_11.getText();
                    String model = textField_12.getText();
                    int year = Integer.parseInt(textField_13.getText());
                    int power = Integer.parseInt(textField_14.getText());
                    float fuel = Float.parseFloat(textField_15.getText());
                    float price = Float.parseFloat(textField_16.getText());
                    ICar c=new ProxyCar(id,make,model,year,power,fuel,price);
                    JLabel imgLabel = new JLabel(new ImageIcon(make+model+".jpg"));
                    imgLabel.setBounds(550, 350, 280, 200);
                    contentPane.add(imgLabel);
                    String input = "{\"carId\":\"" + id + "\",\"make\":\"" + make + "\","
                            + " \"model\":\"" + model + "\","
                            + " \"year\":\"" + year + "\","
                            + " \"horsePower\":\"" + power + "\","
                            + " \"fuelConsumption\":\"" + fuel + "\","
                            + " \"price\":\"" + price + "\"}";
                    String url = "http://localhost:8080/rest/car";
                    if (cmd.equals("Open")) {
                        jsonSendUser(input, url);
                    }
                }
            }
        });
        btnInsertCar.setBounds(47, 312, 150, 32);
        btnInsertCar.setActionCommand("Open");
        contentPane.add(btnInsertCar);

        JButton btnNewButton12 = new JButton("Update car");
        btnNewButton12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if (textField_10.getText().equals("") || !Pattern.matches("[0-9]+", textField_10.getText()))
                    JOptionPane.showMessageDialog(null, "Invalid car id");
                else if (textField_11.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid make");
                else if (textField_12.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid model");
                else if (textField_13.getText().equals("") || !Pattern.matches("[0-9]+", textField_13.getText()))
                    JOptionPane.showMessageDialog(null, "Invalid year");
                else if (textField_14.getText().equals("") || !Pattern.matches("[0-9]+", textField_14.getText()))
                    JOptionPane.showMessageDialog(null, "Invalid horse power");
                else if (textField_15.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid fuel consumption");
                else if (textField_16.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid price");
                else {
                    int id = Integer.parseInt(textField_10.getText());
                    String make=textField_11.getText();
                    String model = textField_12.getText();
                    int year = Integer.parseInt(textField_13.getText());
                    int power = Integer.parseInt(textField_14.getText());
                    float fuel = Float.parseFloat(textField_15.getText());
                    float price = Float.parseFloat(textField_16.getText());
                    ICar c=new ProxyCar(id,make,model,year,power,fuel,price);
                    String input = "{\"carId\":\"" + id + "\",\"make\":\"" + make + "\","
                            + " \"model\":\"" + model + "\","
                            + " \"year\":\"" + year + "\","
                            + " \"horsePower\":\"" + power + "\","
                            + " \"fuelConsumption\":\"" + fuel + "\","
                            + " \"price\":\"" + price + "\"}";
                    String url = "http://localhost:8080/rest/car";
                    if (cmd.equals("Open")) {
                        jsonSendUser1(input, url);
                    }
                }
            }
        });
        btnNewButton12.setBounds(47, 355, 150, 32);
        btnNewButton12.setActionCommand("Open");
        contentPane.add(btnNewButton12);

        JButton btnNewButton_112 = new JButton("Delete car");
        btnNewButton_112.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if (textField_10.getText().equals("") || !Pattern.matches("[0-9]+", textField_10.getText()))
                    JOptionPane.showMessageDialog(null, "Invalid car id");
                else {
                    int id = Integer.parseInt(textField_10.getText());
                    String input = "{\"carId\":\"" + id + "\"}";
                    String url = "http://localhost:8080/rest/car";
                    if (cmd.equals("Open")) {
                        jsonSendUser2(input, url);
                    }
                }
            }
        });
        btnNewButton_112.setBounds(47, 398, 150, 32);
        btnNewButton_112.setActionCommand("Open");
        contentPane.add(btnNewButton_112);

        JButton btnLogout = new JButton("Log out");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if (cmd.equals("Open")) {
                    dispose();
                    new StartupFrame();
                }
            }
        });

        btnLogout.setBounds(45, 441, 150, 32);
        btnLogout.setActionCommand("Open");
        contentPane.add(btnLogout);

        JLabel lblIdEmployee = new JLabel("Id customer");
        lblIdEmployee.setBounds(250, 54, 101, 23);
        contentPane.add(lblIdEmployee);

        textField = new JTextField();
        textField.setBounds(374, 54, 116, 23);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblUsername = new JLabel("Name");
        lblUsername.setBounds(250, 97, 86, 14);
        contentPane.add(lblUsername);

        textField_1 = new JTextField();
        textField_1.setBounds(374, 97, 116, 23);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblPassword = new JLabel("Username");
        lblPassword.setBounds(250, 140, 86, 14);
        contentPane.add(lblPassword);

        textField_2 = new JTextField();
        textField_2.setBounds(374, 140, 116, 23);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblType = new JLabel("Card number");
        lblType.setBounds(250, 186, 86, 14);
        contentPane.add(lblType);

        textField_3 = new JTextField();
        textField_3.setBounds(374, 186, 116, 23);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        JLabel lblCnp = new JLabel("CNP");
        lblCnp.setBounds(250, 232, 86, 14);
        contentPane.add(lblCnp);

        textField_4 = new JTextField();
        textField_4.setBounds(374, 232, 116, 23);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        JLabel lblAdd = new JLabel("Address");
        lblAdd.setBounds(250, 278, 86, 14);
        contentPane.add(lblAdd);

        textField_5 = new JTextField();
        textField_5.setBounds(374, 278, 116, 23);
        contentPane.add(textField_5);
        textField_5.setColumns(10);

        JLabel lblPass = new JLabel("Password");
        lblPass.setBounds(250, 324, 86, 14);
        contentPane.add(lblPass);

        textField_6 = new JTextField();
        textField_6.setBounds(374, 324, 116, 23);
        contentPane.add(textField_6);
        textField_6.setColumns(10);

        JLabel lblem = new JLabel("Id employee");
        lblem.setBounds(250, 370, 86, 14);
        contentPane.add(lblem);

        textField_7 = new JTextField();
        textField_7.setBounds(374, 370, 116, 23);
        contentPane.add(textField_7);
        textField_7.setColumns(10);

        JLabel lblge = new JLabel("Genre");
        lblge.setBounds(250, 416, 86, 14);
        contentPane.add(lblge);

        textField_8 = new JTextField();
        textField_8.setBounds(374, 416, 116, 23);
        contentPane.add(textField_8);
        textField_8.setColumns(10);

        JLabel lblh = new JLabel("Hire date");
        lblh.setBounds(250, 462, 86, 14);
        contentPane.add(lblh);

        textField_9 = new JTextField();
        textField_9.setBounds(374, 462, 116, 23);
        contentPane.add(textField_9);
        textField_9.setColumns(10);

        JLabel lblIdCar = new JLabel("Id car");
        lblIdCar.setBounds(550, 54, 101, 23);
        contentPane.add(lblIdCar);

        textField_10 = new JTextField();
        textField_10.setBounds(670, 54, 116, 23);
        contentPane.add(textField_10);
        textField_10.setColumns(10);

        JLabel lblMake = new JLabel("Make");
        lblMake.setBounds(550, 97, 86, 14);
        contentPane.add(lblMake);

        textField_11 = new JTextField();
        textField_11.setBounds(670, 97, 116, 23);
        contentPane.add(textField_11);
        textField_11.setColumns(10);

        JLabel lblModel = new JLabel("Model");
        lblModel.setBounds(550, 140, 86, 14);
        contentPane.add(lblModel);

        textField_12 = new JTextField();
        textField_12.setBounds(670, 140, 116, 23);
        contentPane.add(textField_12);
        textField_12.setColumns(10);

        JLabel lblYear = new JLabel("Year");
        lblYear.setBounds(550, 186, 86, 14);
        contentPane.add(lblYear);

        textField_13 = new JTextField();
        textField_13.setBounds(670, 186, 116, 23);
        contentPane.add(textField_13);
        textField_13.setColumns(10);

        JLabel lblhp = new JLabel("Horse power");
        lblhp.setBounds(550, 232, 86, 14);
        contentPane.add(lblhp);

        textField_14 = new JTextField();
        textField_14.setBounds(670, 232, 116, 23);
        contentPane.add(textField_14);
        textField_14.setColumns(10);

        JLabel lblfc = new JLabel("Fuel consumption");
        lblfc.setBounds(550, 278, 100, 14);
        contentPane.add(lblfc);

        textField_15 = new JTextField();
        textField_15.setBounds(670, 278, 116, 23);
        contentPane.add(textField_15);
        textField_15.setColumns(10);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setBounds(550, 324, 86, 14);
        contentPane.add(lblPrice);

        textField_16 = new JTextField();
        textField_16.setBounds(670, 324, 116, 23);
        contentPane.add(textField_16);
        textField_16.setColumns(10);


        setVisible(true);
    }

    public void jsonSendUser(String input, String url) {
        try {
            Client client = Client.create();

            WebResource webResource = client.resource(url);
            System.out.println(input);

            // POST method
            ClientResponse response = webResource.accept("application/json")
                    .type("application/json").post(ClientResponse.class, input);

            // check response status code
            if (response.getStatus() != 201) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            // display response
            String output = response.getEntity(String.class);
            System.out.println("Output from Server .... ");
            System.out.println(output + "\n");
            JOptionPane.showMessageDialog(null, output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void jsonSendUser1(String input, String url) {
        try {
            Client client = Client.create();

            WebResource webResource = client.resource(url);
            System.out.println(input);

            // POST method
            ClientResponse response = webResource.accept("application/json")
                    .type("application/json").put(ClientResponse.class, input);

            // check response status code
            if (response.getStatus() != 201) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            // display response
            String output = response.getEntity(String.class);
            System.out.println("Output from Server .... ");
            System.out.println(output + "\n");
            JOptionPane.showMessageDialog(null, output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void jsonSendUser2(String input, String url) {
        try {
            Client client = Client.create();

            WebResource webResource = client.resource(url);
            System.out.println(input);

            // POST method
            ClientResponse response = webResource.accept("application/json")
                    .type("application/json").delete(ClientResponse.class, input);

            // check response status code
            if (response.getStatus() != 201) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            // display response
            String output = response.getEntity(String.class);
            System.out.println("Output from Server .... ");
            System.out.println(output + "\n");
            JOptionPane.showMessageDialog(null, output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}