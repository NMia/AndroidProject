package com.androiddev.brianrecuero.androidfinalproject;

/**
 * Created by Nazim on 12/2/2017.
 */

public class Account
{
    private String userName;
    private String email;
    private String password;

    Account(String uN, String eM, String pW)
    {
        setUserName(uN) ;
        setEmail(eM);
        setPassword(pW);
    }

    public String getUserName()
    {
        return userName;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setUserName(String uN)
    {
        userName = uN;
    }

    public void setEmail(String eM)
    {
        email = eM;
    }

    public void setPassword(String pW)
    {
        password = pW;
    }

    public String toString()
    {
        return "UserName: " + getUserName() + " (Email: " + getEmail() + ") ";
    }
}
