package com.astrology.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Modes")
public class Mode {

    private String mode;
    private String attributes;

    public Mode(String mode, String attributes) {
        this.mode = mode;
        this.attributes = attributes;
    }

    public Mode() {
    }
}
