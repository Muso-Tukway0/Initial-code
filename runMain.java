/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.uniapp.uniapp;

import javax.swing.JOptionPane;

/**
 *
 * @author musot
 */
public class runMain {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to the roomm available tracker App!\nThis application helps CPUT students find available accomodation in real-time. \nRegister or log in to begin.");
    
        Register roomTracker = new Register();
        roomTracker.setVisible(true);
    }

}
