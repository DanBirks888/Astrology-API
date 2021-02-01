package com.astrology.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Signs")
public class Sign {

    @Id
    private String zodiac;
    private String element;
    private String mode;
    private int house;
    private String attributes;

    public Sign(String zodiac, String element, String mode, int house, String attributes) {
        this.zodiac = zodiac;
        this.element = element;
        this.mode = mode;
        this.house = house;
        this.attributes = attributes;
    }

    public Sign() {
    }


}
