/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.uniapp.uniapp;

import java.util.ArrayList;

/**
 *
 * @author musot
 */
public class User {

    private String userName;
    private String password;
    private static ArrayList<User> users = new ArrayList<>();

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public static boolean addUser(User user) {
        for (User u : users) {
            if (u.getUserName().equals(user.getUserName())) {
                return false;
            }
        }
        users.add(user);
        return true;
    }

    public static boolean authenticate(String userName, String password) {
        for (User u : users) {
            if (u.getUserName().equals(userName) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
