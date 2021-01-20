package com.astrology;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sign {

    private String name;
    private String element;
    private String signMeaning;

    public Sign(String name, String element, String signMeaning) {
        this.name = name;
        this.element = element;
        this.signMeaning = signMeaning;
    }

    public Sign() {
    }
}
