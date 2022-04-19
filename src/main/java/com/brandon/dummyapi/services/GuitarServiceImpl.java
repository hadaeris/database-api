package com.brandon.dummyapi.services;

import com.brandon.dummyapi.domain.Guitar;
import com.brandon.dummyapi.exceptions.GuitarBadRequestException;
import com.brandon.dummyapi.exceptions.GuitarNotFoundException;
import com.brandon.dummyapi.repositories.GuitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GuitarServiceImpl implements GuitarService {

    @Autowired
    GuitarRepository guitarRepository;

    @Override
    public List<Guitar> fetchAllGuitars(Integer ownerId) {
        return null;
    }

    @Override
    public Guitar fetchCategoryById(Integer ownerId, Integer guitarId) throws GuitarNotFoundException {
        return null;
    }

    @Override
    public Guitar addGuitar(Integer ownerId, String color, String frets, Integer stringCount, Integer body) throws GuitarBadRequestException {
        int guitarId = guitarRepository.create(ownerId, color, frets, stringCount, body);
        return guitarRepository.findById(guitarId);
    }

    @Override
    public void updateGuitar(Integer guitarId, Guitar guitar) throws GuitarBadRequestException {
        //incomplete
    }

    @Override
    public void removeGuitarWithAllTransactions(Integer guitarId) throws GuitarBadRequestException {
        //incomplete
    }
}
