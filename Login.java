/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.uniapp.uniapp;

/**
 *
 * @author musot
 */
import javax.swing.*;
import java.awt.*;
import java.io.*;

// LoginForm.java
public class Login extends BaseForm {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnBack;

    public Login() {
        super("Room Tracker - Login");

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        txtUsername = new JTextField();
        txtPassword = new JPasswordField();
        btnLogin = new JButton("Login");
        btnBack = new JButton("Back to Register");

        panel.add(new JLabel("Username:"));
        panel.add(txtUsername);
        panel.add(new JLabel("Password:"));
        panel.add(txtPassword);
        panel.add(btnLogin);
        panel.add(btnBack);

        add(panel, BorderLayout.CENTER);

        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText().trim();
            String password = new String(txtPassword.getPassword());

            if (User.authenticate(username, password)) {
                JOptionPane.showMessageDialog(this, "Login successful! Checking available rooms...");
                // You can launch the dashboard or next window here.
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials.");
            }
        });

        btnBack.addActionListener(e -> {
            new Register().setVisible(true);
            dispose();
        });
    }

    private boolean ahenticateFromFile(String username, String password) {
        File file = new File("users.txt");
        if (!file.exists()) {
            return false;
        }
        try ( BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    if (parts[0].equals(username) && parts[1].equals(password)) {
                        return false;
                    }
                }
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading user file.");
        }
        return false;

    }
}
