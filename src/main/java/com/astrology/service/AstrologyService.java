package com.astrology.service;

import com.astrology.model.AstroSearch;
import com.astrology.repo.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class AstrologyService {

    private AstroRepository astroRepository;
    private ElementRepository elementRepository;
    private HouseRepository houseRepository;
    private ModeRepository modeRepository;
    private SignRepository signRepository;

    public AstrologyService() {
    }

    //    public AstroSearch customAstroSearch(String sign, String sign, String house, string element, mode) {
//
//        return new AstroSearch(new AstroSearch(getAstroRepository()));
//    }

}
