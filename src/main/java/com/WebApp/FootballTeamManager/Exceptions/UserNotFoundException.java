package com.WebApp.FootballTeamManager.Exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String s) {
        super(s);
    }
}
