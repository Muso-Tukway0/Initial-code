/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.uniapp.uniapp;

/**
 *
 * @author musot
 */
// RegisterForm.java
import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Register extends BaseForm {

    private JTextField txtFullName, txtStudentId, txtUsername, txtEmail, txtCellNumber, txtID, txtPassport, txtHomeAddress;
    private JPasswordField txtPassword, txtConfirmPassword;
    private JButton btnSignup, btnLogin, btnExit, btnClear;

    public Register() {
        super("Room Tracker - Register");

        JPanel pnlForm = new JPanel(new GridLayout(10, 2, 8, 8));
        JPanel pnlButtons = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        //JPanel pnlFields = new JPanel(new GridLayout(9,1,5,5));
        JPanel pnlMain = new JPanel(new BorderLayout());

        txtFullName = new JTextField();
        txtStudentId = new JTextField();
        txtUsername = new JTextField();
        txtEmail = new JTextField();
        txtCellNumber = new JTextField();
        txtID = new JTextField();
        txtPassport = new JTextField();
        txtHomeAddress = new JTextField();
        txtPassword = new JPasswordField();
        txtConfirmPassword = new JPasswordField();

        pnlForm.add(new JLabel("Full Name:"));
        pnlForm.add(txtFullName);
        pnlForm.add(new JLabel("Student ID:"));
        pnlForm.add(txtStudentId);
        pnlForm.add(new JLabel("Username:"));
        pnlForm.add(txtUsername);
        pnlForm.add(new JLabel("Email:"));
        pnlForm.add(txtEmail);
        pnlForm.add(new JLabel("Cell Number:"));
        pnlForm.add(txtCellNumber);
        pnlForm.add(new JLabel("ID Number:"));
        pnlForm.add(txtID);
        pnlForm.add(new JLabel("Passport Number:"));
        pnlForm.add(txtPassport);
        pnlForm.add(new JLabel("Home Address:"));
        pnlForm.add(txtHomeAddress);
        pnlForm.add(new JLabel("Password:"));
        pnlForm.add(txtPassword);
        pnlForm.add(new JLabel("Confirm Password:"));
        pnlForm.add(txtConfirmPassword);

        btnSignup = new JButton("SIGN UP");
        btnLogin = new JButton("Already have an account?");
        btnExit = new JButton("EXIT");
        btnClear = new JButton("CLEAR");

        pnlButtons.add(btnSignup);
        pnlButtons.add(btnLogin);
        pnlButtons.add(btnClear);
        pnlButtons.add(btnExit);
        

        add(pnlForm, BorderLayout.CENTER);
        add(pnlButtons, BorderLayout.SOUTH);

        btnSignup.addActionListener(e -> {
            String fullName = txtFullName.getText();
            String studentID = txtStudentId.getText();
            String username = txtUsername.getText().trim();
            String pass = new String(txtPassword.getPassword());
            String confirm = new String(txtConfirmPassword.getPassword());
            String cellNumber = txtCellNumber.getText();
            String email = txtEmail.getText();

            if (username.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username and password are required.");
                return;
            }
            if (fullName.isEmpty() || cellNumber.isEmpty() || studentID.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be filled!");

            }

            if (!username.matches("^[a-zA-Z0-9._-]{5,}$")) {
                JOptionPane.showMessageDialog(this, "Username must be at least 5 characters and contain no spaces.");
                return;
            }
            if (!cellNumber.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(this, "Cell number must be 10 digits");

            }
            if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                JOptionPane.showMessageDialog(this, "Invalid emial address.");
            }

            if (!pass.equals(confirm)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match.");
                return;
            }

            try ( BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
                writer.write(username + "," + pass);
                writer.newLine();
                JOptionPane.showMessageDialog(this, "Registration successful!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving user data: " + ex.getMessage());
            }
            boolean added = User.addUser(new User(username, pass));
            if (added) {
                JOptionPane.showMessageDialog(this, "Registration successful");
            } else {
                JOptionPane.showMessageDialog(this, "Username already exists");
            }
        });
        btnExit.addActionListener(e->{
            System.exit(0);
        });
        btnClear.addActionListener(e ->{
            txtCellNumber.setText(" ");
            txtConfirmPassword.setText(" ");
            txtEmail.setText(" ");
            txtFullName.setText(" ");
            txtHomeAddress.setText(" ");
            txtID.setText(" ");
            txtPassport.setText(" ");
            txtPassword.setText(" ");
            txtStudentId.setText(" ");
            txtUsername.setText(" ");
        });

        btnLogin.addActionListener(e -> {
            new Login().setVisible(true);
            dispose();
        });
    }
}
