package com.mkyong.client;

import com.mkyong.model.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.util.List;

public class CustomerFrame extends JFrame {
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
    private int customerId;

    public CustomerFrame(int customerId) {
        super("Customer User");
        this.customerId=customerId;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1100, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 255, 153));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Fill contract");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if(textField.getText().equals("")|| !Pattern.matches("[0-9]+", textField.getText()))
                    JOptionPane.showMessageDialog(null, "Invalid contract id");
                else if(textField_1.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid contract date");
                else if(textField_2.getText().equals("")|| !Pattern.matches("[0-9]+", textField_2.getText()))
                    JOptionPane.showMessageDialog(null, "Invalid car id");
                else if(textField_3.getText().equals("")|| !Pattern.matches("[0-9]+", textField_3.getText()))
                    JOptionPane.showMessageDialog(null, "Invalid employee id");
                else {
                    int id=Integer.parseInt(textField.getText());
                    String date=textField_1.getText();
                    int carId=Integer.parseInt(textField_2.getText());
                    int employeeId=Integer.parseInt(textField_3.getText());
                    Contract c = new Contract(id,date,carId,customerId,employeeId);
                    String input = "{\"contractId\":\"" + id + "\",\"date\":\"" + date + "\","
                            + " \"carId\":\"" + carId + "\","
                            + " \"customerId\":\"" + customerId + "\","
                            + " \"employeeId\":\"" + employeeId + "\"}";
                    String url = "http://localhost:8080/rest/contract";
                    if (cmd.equals("Open")) {
                        jsonSendContract(input, url);
                    }
                }
            }
        });
        btnNewButton.setBounds(51, 51, 200, 34);
        btnNewButton.setActionCommand("Open");
        contentPane.add(btnNewButton);

        JButton btnViewDetailsAbout = new JButton("View cars");
        btnViewDetailsAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                    if (cmd.equals("Open")) {
                        jsonGetCars();
                    }
                }
        });
        btnViewDetailsAbout.setBounds(51, 96, 200, 34);
        btnViewDetailsAbout.setActionCommand("Open");
        contentPane.add(btnViewDetailsAbout);

        JButton btnAddDetails = new JButton("Add additional parts");
        btnAddDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if(textField_4.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid additional parts");
                else {
                    String details = textField_4.getText();
                    String input = "{\"customerId\":\"" + customerId + "\",\"details\":\"" + details + "\"}";
                    String url = "http://localhost:8080/rest/contract/parts";
                    if (cmd.equals("Open")) {
                        jsonSendContract(input,url);
                    }
                }
            }
        });
        btnAddDetails.setBounds(51, 141, 200, 34);
        btnAddDetails.setActionCommand("Open");
        contentPane.add(btnAddDetails);

        JButton btnSearchByMark = new JButton("Search by make and model");
        btnSearchByMark.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if(textField_5.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid make");
                else if(textField_6.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid model");
                else {
                    String make = textField_5.getText();
                    String model=textField_6.getText();
                    JLabel imgLabel = new JLabel(new ImageIcon(make+model+".jpg"));
                    imgLabel.setBounds(550, 100, 550, 600);
                    contentPane.add(imgLabel);
                    String url = "http://localhost:8080/rest/car/"+make+"/"+model;
                    if (cmd.equals("Open")) {
                        jsonGetCar(url);
                    }
                }
            }
        });
        btnSearchByMark.setBounds(51, 186, 200, 34);
        btnSearchByMark.setActionCommand("Open");
        contentPane.add(btnSearchByMark);

        JButton btnSearchByPrice = new JButton("Filter by price");
        btnSearchByPrice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if (textField_7.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid price");
                else {
                    float price=Float.parseFloat(textField_7.getText());
                    if (cmd.equals("Open")) {
                        ICar c=new ProxyCar();
                        List<ProxyCar> cars = c.getAllCars();
                        PriceCriteria pc = new PriceCriteria(price);
                        printCars(pc.meetCriteria(cars));
                    }
                }
            }
        });
        btnSearchByPrice.setBounds(51, 226, 200, 34);
        btnSearchByPrice.setActionCommand("Open");
        contentPane.add(btnSearchByPrice);

        JButton btnSearchByYear = new JButton("Filter by year");
        btnSearchByYear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if (textField_8.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid year");
                else {
                    int year=Integer.parseInt((textField_8.getText()));
                    if (cmd.equals("Open")) {
                        ICar c=new ProxyCar();
                        List<ProxyCar> cars = c.getAllCars();
                        YearCriteria pc = new YearCriteria(year);
                        printCars(pc.meetCriteria(cars));
                    }
                }
            }
        });
        btnSearchByYear.setBounds(51, 266, 200, 34);
        btnSearchByYear.setActionCommand("Open");
        contentPane.add(btnSearchByYear);

        JButton btnLogOut = new JButton("Log Out");
        btnLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if(cmd.equals("Open"))
                {
                    dispose();
                    new StartupFrame();
                }
            }
        });
        btnLogOut.setBounds(51, 421, 200, 34);
        btnLogOut.setActionCommand("Open");
        contentPane.add(btnLogOut);

        JLabel lblConsultationId = new JLabel("Contract id");
        lblConsultationId.setBounds(263, 61, 110, 14);
        contentPane.add(lblConsultationId);

        textField = new JTextField();
        textField.setBounds(383, 58, 126, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblDate = new JLabel("Date");
        lblDate.setBounds(263, 101, 46, 14);
        contentPane.add(lblDate);

        JLabel lblDiagnostic = new JLabel("Car id");
        lblDiagnostic.setBounds(263, 141, 110, 14);
        contentPane.add(lblDiagnostic);

        textField_1 = new JTextField();
        textField_1.setBounds(383, 98, 126, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(383, 138, 126, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblDoctorId = new JLabel("Employee id");
        lblDoctorId.setBounds(263, 181, 85, 14);
        contentPane.add(lblDoctorId);

        textField_3 = new JTextField();
        textField_3.setBounds(383, 178, 126, 20);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        JLabel lblPatientId = new JLabel("Additional parts");
        lblPatientId.setBounds(263, 221, 135, 14);
        contentPane.add(lblPatientId);

        textField_4 = new JTextField();
        textField_4.setBounds(383, 218, 126, 20);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        JLabel lblMake = new JLabel("Make");
        lblMake.setBounds(263, 261, 135, 14);
        contentPane.add(lblMake);

        textField_5 = new JTextField();
        textField_5.setBounds(383, 258, 126, 20);
        contentPane.add(textField_5);
        textField_5.setColumns(10);

        JLabel lblModel = new JLabel("Model");
        lblModel.setBounds(263, 301, 135, 14);
        contentPane.add(lblModel);

        textField_6 = new JTextField();
        textField_6.setBounds(383, 298, 126, 20);
        contentPane.add(textField_6);
        textField_6.setColumns(10);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setBounds(263, 341, 135, 14);
        contentPane.add(lblPrice);

        textField_7 = new JTextField();
        textField_7.setBounds(383, 338, 126, 20);
        contentPane.add(textField_7);
        textField_7.setColumns(10);

        JLabel lblYear = new JLabel("Year");
        lblYear.setBounds(263, 381, 135, 14);
        contentPane.add(lblYear);

        textField_8 = new JTextField();
        textField_8.setBounds(383, 378, 126, 20);
        contentPane.add(textField_8);
        textField_8.setColumns(10);


        setVisible(true);
    }
    public void jsonSendContract(String input,String url)
    {
        try {
            Client client = Client.create();

            WebResource webResource = client.resource(url);
            System.out.println(input);

            // PUT method
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
    public void jsonGetCars() {
        try {

            Client client = Client.create();

            WebResource webResource = client
                    .resource("http://localhost:8080/rest/car");

            ClientResponse response = webResource.accept("application/json")
                    .get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            String output = response.getEntity(String.class);

            System.out.println("Output from Server .... \n");
            System.out.println(output);
            //JOptionPane.showMessageDialog(null, output);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    public void jsonGetCar(String url) {
        try {

            Client client = Client.create();
            WebResource webResource = client
                    .resource(url);

            ClientResponse response = webResource.accept("application/json")
                    .get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            String output = response.getEntity(String.class);

            System.out.println("Output from Server .... \n");
            System.out.println(output);
            //JOptionPane.showMessageDialog(null, output);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    public static void printCars(List<ProxyCar> cars){
        String s="";
        for (ProxyCar car : cars) {
            s = s + car.toString();
            s = s + "\n";
        }
            JOptionPane.showMessageDialog(null,s);
    }
}

