/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADPPrac5;

import java.util.regex.*;
/**
 *
 * @Inga Mbobo 230711723
 */
public class User {
    private String userName;
    private String userPass;
    private boolean isValid;

    public User(String n, String pass) {
        this.userName = n;
        this.userPass = pass;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPass() {
        return userPass;
    }
    
      public void setName(final String n)
    {
        this.userName = n;
    }
    
    public void setPassword(final String pass)
    {
        this.userPass = pass;
    }
    
    public boolean isValid()
    {
        Pattern p = Pattern.compile("[^A-Za-z0-9 ]");           //Taken from pencilprogrammer.com
        Matcher m = p.matcher(userPass);
        if (m.find() ) {
            isValid = true;
        } else {
            isValid = false;
        }
        return isValid;
    }
    
    public String toString()
    {
        return userName + " " + userPass;
    }
}
