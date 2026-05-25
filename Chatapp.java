/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

import java.util.Scanner;

/**
 *
 * @author retha
 */
public class Chatapp {

    public static void main(String[] args) {
        
         Scanner myInput = new Scanner(System.in);

        // Registration
        System.out.println("--- Registration ---");

        System.out.print("Enter username: ");
        String username = myInput.nextLine();

        System.out.print("Enter password: ");
        String password = myInput.nextLine();

        System.out.print("Enter cell phone number: ");
        String phone = myInput.nextLine();

        Login user = new Login(username, password, phone);

        System.out.println(user.registerUser());

        // Login
        System.out.println("--- Login ---");

        System.out.print("Enter username: ");
        String loginUsername = myInput.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = myInput.nextLine();

        boolean success = user.loginUser(loginUsername,
                loginPassword);

        System.out.print("Enter first name: ");
        String firstName = myInput.nextLine();

        System.out.print("Enter last name: ");
        String lastName = myInput.nextLine();

        System.out.println(user.returnLoginStatus(success,firstName,lastName));
        
        
        //Part 2
        if (success){
            System.out.println("Welcome to QuickChat.");
            System.out.print("How many messages would you like to send?");
            int numMessages = myInput.nextInt();
            myInput.nextLine();
            
            Message.recipients = new String[numMessages];
            Message.messages = new String[numMessages];
            Message.messageIDs = new String[numMessages];
            Message.messageFlags = new String[numMessages];
            
            for (int i=0; i< numMessages; i++){
                System.out.println("Message" + (i+1));
                
                System.out.print("Enter recipient number:");
                String recipient = myInput.nextLine();
                
                System.out.print("Enter message");
                String messageText = myInput.nextLine();
                
                Message msg = new Message(i+1, recipient, messageText);
                
                System.out.println(msg.checkRecipientCell());
                System.out.println(msg.checkMessageLength());
                
                if (msg.checkMessageLength().equals("Message ready to send.")){
                    System.out.println(msg.sentMessage());
                    System.out.println(msg.printMessages());
                    
                    Message.recipients[i] = recipient;
                    Message.messages[i] = messageText;
                    Message.messageFlags[i] = "Processed";
                }
            }
            System.out.println("Total messages sent:" + Message.returnTotalMessages());
            
            System.out.println("\n==================================");
            System.out.println("       QUICKCHAT SUMMARY REPORT    ");
            System.out.println("==================================");
            
            for (int i = 0; i < numMessages; i++) {
                System.out.println("Message #" + (i + 1));
                System.out.println("Recipient: " + Message.recipients[i]);
                System.out.println("Message Text: " + Message.messages[i]);
                System.out.println("Status/Flag: " + Message.messageFlags[i]);
                System.out.println("----------------------------------");
        }
    }
}}
    
