package com.brandon.dummyapi.services;

import com.brandon.dummyapi.domain.Guitar;
import com.brandon.dummyapi.exceptions.GuitarBadRequestException;
import com.brandon.dummyapi.exceptions.GuitarNotFoundException;

import java.util.List;

public interface GuitarService {

    List<Guitar> fetchAllGuitars(Integer ownerId);

    Guitar fetchCategoryById(Integer ownerId, Integer guitarId) throws GuitarNotFoundException;

    Guitar addGuitar(Integer ownerId, String color, String frets, Integer stringCount, Integer body) throws GuitarBadRequestException;

    void updateGuitar(Integer guitarId, Guitar guitar) throws GuitarBadRequestException;

    void removeGuitarWithAllTransactions(Integer guitarId) throws GuitarBadRequestException;

}
