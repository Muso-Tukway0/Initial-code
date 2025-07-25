/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.uniapp.uniapp;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author musot
 */
public abstract class BaseForm extends JFrame {

    public BaseForm(String title) {
        super("Room Tracker - Register");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

}
