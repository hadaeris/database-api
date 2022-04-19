package com.brandon.dummyapi.domain;

public class User {
    private Integer user_id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public Integer getUser_id() {
        return user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User(Integer user_id, String firstName, String lastName, String email, String password) {
        this.user_id = user_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
