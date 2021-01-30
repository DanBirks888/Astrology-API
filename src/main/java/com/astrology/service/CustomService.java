package com.astrology.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class CustomService {

    private AstralBodyService astralBodyService;
    private SignService signService;

//    public AstroSearch customAstroSearch(String body, String sign, int house, String element, String mode) {
//
//    }

}
