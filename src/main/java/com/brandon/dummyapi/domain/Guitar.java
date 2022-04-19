package com.brandon.dummyapi.domain;

public class Guitar {
    private Integer guitar_id;
    private String color;
    private String frets;
    private Integer body;
    private Integer stringCount;
    private Integer owner_id;

    public Guitar(Integer guitar_id, String color, String frets, Integer body, Integer stringCount, Integer owner_id) {
        this.guitar_id = guitar_id;
        this.color = color;
        this.frets = frets;
        this.body = body;
        this.stringCount = stringCount;
        this.owner_id = owner_id;
    }

    public Integer getGuitar_id() {
        return guitar_id;
    }

    public String getColor() {
        return color;
    }

    public String getFrets() {
        return frets;
    }

    public Integer getBody() {
        return body;
    }

    public Integer getStringCount() {
        return stringCount;
    }

    public Integer getOwner_id() {
        return owner_id;
    }
}
