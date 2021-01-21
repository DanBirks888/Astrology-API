package com.astrology.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "AstralBody")
public class AstralBody {

    private String astralBody;
    private List<String> singleLineMeaning;
    private String attributes;

    public AstralBody(String astralBody, List<String> singleLineMeaning, String attributes) {
        this.astralBody = astralBody;
        this.singleLineMeaning = singleLineMeaning;
        this.attributes = attributes;
    }

    public AstralBody() {
    }
}