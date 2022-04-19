package com.brandon.dummyapi.repositories;

import com.brandon.dummyapi.domain.Guitar;
import com.brandon.dummyapi.exceptions.GuitarBadRequestException;
import com.brandon.dummyapi.exceptions.GuitarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class GuitarRepositoryImpl implements GuitarRepository {

    private static final String SQL_CREATE = "INSERT INTO GUITARS (GUITAR_ID, COLOR, FRETS, BODY, STRINGS, OWNER) " +
            "VALUES(NEXTVAL('GUITARS_SEQ'), ?, ?, ?, ?, ?)";
    private static final String SQL_FINDALL = "SELECT * FROM GUITARS";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Guitar> findAll() throws GuitarNotFoundException {
//        try {
//            return jdbcTemplate.query(SQL_FINDALL, new Object[]{}, guitarRowMapper);
//        }
        return null;
    }

    @Override
    public Guitar findById(Integer guitarId) throws GuitarNotFoundException {
        return null;
    }

    @Override
    public Integer create(Integer ownerId, String color, String frets, Integer stringCount, Integer body) throws GuitarBadRequestException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
               PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
               ps.setString(1, color);
               ps.setString(2, frets);
               ps.setInt(3, stringCount);
               ps.setInt(4, body);
               ps.setInt(5, ownerId);
               return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("GUITAR_ID");
        } catch (Exception e) {
            throw new GuitarBadRequestException("Invalid request (in creating new guitar)");
        }
    }

    @Override
    public void update(Integer guitarId, Guitar guitar) throws GuitarBadRequestException {

    }

    @Override
    public void removeById(Integer guitarId) {

    }

    private RowMapper<Guitar> guitarRowMapper = ((rs,  rowNum) -> {
        return new Guitar(rs.getInt("GUITAR_ID"),
                rs.getString("COLOR"),
                rs.getString("FRETS"),
                rs.getInt("BODY"),
                rs.getInt("STRINGS"),
                rs.getInt("OWNER_ID"));
    });
}
