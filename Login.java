/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

/**
 *
 * @author retha
 */
public class Login {
    
    String userName;
    String password;
    String cellPhone;
    
    public Login(String userName, String password, String cellPhone) {
        this.userName = userName;
        this.password = password;
        this.cellPhone = cellPhone;
    }
    public boolean checkUserName() {
        return userName.contains("_")&& userName.length() <=5;
    }
    public boolean checkPasswordComplexity(){
        if (password.length()<8){
            return false;
        }
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        
        for (char c : password.toCharArray()) {

            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }

            else if (Character.isDigit(c)) {
                hasDigit = true;
            }

            else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        return hasUpper && hasDigit && hasSpecial;
    }

    public boolean checkCellPhoneNumber() {
        return cellPhone.matches("\\+27\\d{9}");
    }

    public String registerUser() {

        if (checkUserName()) {
            System.out.println("Username successfully captured.");
        } else {
            return "Username is not correctly formatted.";
        }

        if (checkPasswordComplexity()) {
            System.out.println("Password successfully captured.");
        } else {
            return "Password is not correctly formatted.";
        }

        if (checkCellPhoneNumber()) {
            System.out.println("Cell phone number successfully captured.");
        } else {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        return "Registration successful.";
    }

    public boolean loginUser(String enteredUsername,
            String enteredPassword) {

        return enteredUsername.equals(userName)
                && enteredPassword.equals(password);
    }

    public String returnLoginStatus(boolean success,
            String firstName,
            String lastName) {

        if (success) {

            return "Welcome "
                    + firstName
                    + " "
                    + lastName
                    + ", it is great to see you again.";

        } else {

            return "Username or password incorrect, please try again.";
    }

    }
}

