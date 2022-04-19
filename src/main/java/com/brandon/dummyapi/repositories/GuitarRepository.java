package com.brandon.dummyapi.repositories;

import com.brandon.dummyapi.domain.Guitar;
import com.brandon.dummyapi.exceptions.GuitarBadRequestException;
import com.brandon.dummyapi.exceptions.GuitarNotFoundException;

import java.util.List;

public interface GuitarRepository {

    List<Guitar> findAll() throws GuitarNotFoundException;

    Guitar findById(Integer guitarId) throws GuitarNotFoundException;

    Integer create(Integer ownerId, String color, String frets, Integer stringCount, Integer body) throws GuitarBadRequestException;

    void update(Integer guitarId, Guitar guitar) throws GuitarBadRequestException;

    void removeById(Integer guitarId);
}
