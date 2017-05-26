package com.mkyong.client;

import com.mkyong.model.Contract;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;


public class EmployeeFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private int employeeId;

    public EmployeeFrame(int employeeId) {
        super("Employee User");
        this.employeeId=employeeId;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 565, 336);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 255, 153));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Create contract");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if(textField.getText().equals("")|| !Pattern.matches("[0-9]+", textField.getText()))
                    JOptionPane.showMessageDialog(null, "Invalid contract id");
                else if(textField_1.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid date");
                else {
                    int id=Integer.parseInt(textField.getText());
                    String date=textField_1.getText();
                    Contract c = new Contract(id,date,0,0,employeeId);
                    String input = "{\"contractId\":\"" + id + "\",\"date\":\"" + date + "\","
                            + " \"carId\":\"" + 1 + "\","
                            + " \"customerId\":\"" + 1 + "\","
                            + "\"employeeId\":\"" + employeeId + "\"}";
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
        btnLogOut.setBounds(51, 141, 200, 34);
        btnLogOut.setActionCommand("Open");
        contentPane.add(btnLogOut);

        JLabel lblConsultationId = new JLabel("Contract id");
        lblConsultationId.setBounds(263, 80, 110, 14);
        contentPane.add(lblConsultationId);

        textField = new JTextField();
        textField.setBounds(383, 80, 126, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblDate = new JLabel("Date");
        lblDate.setBounds(263, 120, 46, 14);
        contentPane.add(lblDate);

        textField_1 = new JTextField();
        textField_1.setBounds(383, 120, 126, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        setVisible(true);
    }
    public void jsonSendContract(String input,String url)
    {
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
}
