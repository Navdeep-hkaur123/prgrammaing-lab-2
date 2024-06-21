package com.example.csd214lab;

public class user {

    private int userID; // Changed from 'id' to 'userID'
    private String username;
    private String useremail; // Changed from 'email' to 'useremail'
    private String userpassword; // Changed from 'password' to 'userpassword'

    public user(int userID, String username, String useremail, String userpassword) {
        this.userID = userID;
        this.username = username;
        this.useremail = useremail;
        this.userpassword = userpassword;
    }

    public int getUserID() { // Changed from 'getId' to 'getUserID'
        return userID;
    }

    public void setUserID(int userID) { // Changed from 'setId' to 'setUserID'
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() { // Changed from 'getEmail' to 'getUseremail'
        return useremail;
    }

    public void setUseremail(String useremail) { // Changed from 'setEmail' to 'setUseremail'
        this.useremail = useremail;
    }

    public String getUserpassword() { // Changed from 'getPassword' to 'getUserpassword'
        return userpassword;
    }

    public void setUserpassword(String userpassword) { // Changed from 'setPassword' to 'setUserpassword'
        this.userpassword = userpassword;
    }
}
