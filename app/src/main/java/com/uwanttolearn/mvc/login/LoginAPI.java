package com.uwanttolearn.mvc.login;

/**
 * Created by hafiz on 29/11/2015.
 */
public class LoginAPI {

    private final String USERNAME = "hafiz";
    private final String PASSWORD = "123456";

    public boolean authenticate(String username, String password){
        if(USERNAME.equals(username) && PASSWORD.equals(password))
            return true;
        return false;
    }
}
