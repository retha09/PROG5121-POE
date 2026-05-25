/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author retha
 */
public class Message {
    
    String messageID;
    int messageNumber;
    String recipient;
    String messageText;
    
    static int totalMessages = 0;
    
    // Global static arrays to store the test data across messages
    public static String[] recipients = new String[5];
    public static String[] messages = new String[5];
    public static String[] messageIDs = new String[5];
    public static String[] messageFlags = new String[5];
    
    //Constructor
    public Message(int messageNumber, String recipient, String messageText){
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        
        Random random = new Random();
        
        messageID = "";
        
        for(int i=0; i<10; i++){
            messageID += random.nextInt(10);
        }
        totalMessages++;
    }
    
    //Check message ID
    public boolean checkMessageID(){
        return messageID.length()<= 10;
    }
   
    //Check recpient number
    public String checkRecipientCell(){
        if (recipient.matches("\\+27\\d{9}")){
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code.";
        }    
        }
    //Check message length
    public String checkMessageLength(){
        if (messageText.length()<= 250){
            return "Message ready to send.";
        } else {
            return "Message exceeds 250 characters by" + (messageText.length()- 250) + "characters.";
        }
    }
    //Create hash
    public String createMessageHash(){
        if(messageText == null || messageText.trim().isEmpty()){
            return "Message hash could not be created.";
        }
        String[] words = messageText.trim().split("");
        String firstWord = words[0];
        String lastWord = words[words.length-1];
        return messageID.substring(0,2) + ":" + messageNumber + ":" + firstWord.toUpperCase() + lastWord.toUpperCase();
    }
    
    //Send, store or delete message
    public String sentMessage(){
        Scanner myInput = new Scanner(System.in);
        
        System.out.println("Choose option:");
        System.out.println("1.Send Message");
        System.out.println("2.Disregard Message");
        System.out.println("3.Store Message");
        
        int choice = myInput.nextInt();
        
        switch(choice){
            case 1 -> {
                return "Message successfully sent.";
            }
            case 2 -> {
                return "Press 0 to delete the message.";
            }
            case 3 -> {
                return "Message successfully stored.";
            }
            default -> {
                return "Invalid option.";
            }
        }
    }
    //Display message 
    public String printMessages(){
        return "Message ID:" + messageID + "Message Hash:" + createMessageHash() + "Recipient:" + recipient + "Message:" + messageText;
    }
    
    //Total messages 
    public static int returnTotalMessages(){
        return totalMessages;
    }
}
