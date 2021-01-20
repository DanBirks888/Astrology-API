package com.astrology.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Element {

    private String name;
    private String description;

    public Element(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
