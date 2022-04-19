package com.brandon.dummyapi.services;

import com.brandon.dummyapi.domain.User;
import com.brandon.dummyapi.exceptions.GuitarAuthException;
import com.brandon.dummyapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws GuitarAuthException {
        if (email != null) email = email.toLowerCase();
        return userRepository.findByEmailPassword(email, password);
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws GuitarAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email != null) email = email.toLowerCase();
        if (!pattern.matcher(email).matches())
            throw new GuitarAuthException("Invalid email format");
        Integer count = userRepository.getCountByEmail(email);
        if (count > 0)
            throw new GuitarAuthException("Email in use");
        Integer userId = userRepository.create(firstName, lastName, email, password);
        return userRepository.findById(userId);
    }
}
