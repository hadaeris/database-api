package com.brandon.dummyapi.repositories;

import com.brandon.dummyapi.domain.User;
import com.brandon.dummyapi.exceptions.GuitarAuthException;

public interface UserRepository
{
    Integer create(String firstName, String lastName, String email, String password) throws GuitarAuthException;

    User findByEmailPassword(String email, String password) throws GuitarAuthException;

    Integer getCountByEmail(String email);

    User findById(Integer userId);
}
