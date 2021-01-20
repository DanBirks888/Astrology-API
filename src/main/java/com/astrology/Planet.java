package com.astrology;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collation = "Planets")
public class Planet {
    @Id
    private String id;
    private String name;
    private String ruler;
    private House house;
    private Sign sign;

    public Planet(String name, String ruler, House house, Sign sign) {
        this.name = name;
        this.ruler = ruler;
        this.house = house;
        this.sign = sign;
    }

    public Planet() {
    }
}