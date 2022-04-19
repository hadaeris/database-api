package com.brandon.dummyapi.services;

import com.brandon.dummyapi.domain.User;
import com.brandon.dummyapi.exceptions.GuitarAuthException;

public interface UserService {

    User validateUser(String email, String password) throws GuitarAuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws GuitarAuthException;

}
