package com.astrology.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AstroSearch {

    private AstralBody astralBody;
    private Sign sign;
    private House house;
    private Element element;
    private Mode mode;

    public AstroSearch(AstralBody astralBody, Sign sign, House house, Element element, Mode mode) {
        this.astralBody = astralBody;
        this.sign = sign;
        this.house = house;
        this.element = element;
        this.mode = mode;
    }
}
