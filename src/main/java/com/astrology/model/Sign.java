package com.astrology.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collation = "Signs")
public class Sign {

    @Id
    private String id;
    private enum Element {
        FIRE, WATER, EARTH, AIR
    }
    private enum Mode {
        CARDINAL, FIXED, MUTABLE
    }
    private House house;
    private AstralBody astralBody;



}
