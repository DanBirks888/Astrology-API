package com.astrology;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class House {

    private int houseNumber;
    private String houseMeaning;

    public House(int houseNumber, String houseMeaning) {
        this.houseNumber = houseNumber;
        this.houseMeaning = houseMeaning;
    }

    public House() {
    }
}
