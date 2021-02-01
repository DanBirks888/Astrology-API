package com.astrology.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Elements")
public class Element {

    @Id
    private String element;
    private String attributes;

    public Element(String element, String attributes) {
        this.element = element;
        this.attributes = attributes;
    }

    public Element() {
    }
}
