package com.astrology.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Houses")
public class House {

    @Id
    private int house;
    private String attributes;

    public House(int house, String attributes) {
        this.house = house;
        this.attributes = attributes;
    }

    public House() {
    }
}
