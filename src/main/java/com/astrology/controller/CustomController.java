package com.astrology.controller;

import com.astrology.model.AstroSearch;
import com.astrology.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custom")
public class CustomController {

    private AstralBodyService astralBodyService;
    private SignService signService;
    private ElementService elementService;
    private HouseService houseService;
    private ModeService modeService;

    public CustomController(AstralBodyService astralBodyService, SignService signService, ElementService elementService, HouseService houseService, ModeService modeService) {
        this.astralBodyService = astralBodyService;
        this.signService = signService;
        this.elementService = elementService;
        this.houseService = houseService;
        this.modeService = modeService;
    }

    //    @GetMapping("/astral/sign/house/element/mode/{astral}/{sign}/{house}/{element}/{mode}")
    @GetMapping("/search/{astral}/{sign}/{house}/{element}/{mode}")
//    @GetMapping("/astral/{astral}/sign/{sign}/house/{house}/element/{element}/mode/{mode}")
    public AstroSearch customSearch(
            @PathVariable("astral") String astral,
            @PathVariable("sign") String sign,
            @PathVariable("house") int house,
            @PathVariable("element") String element,
            @PathVariable("mode") String mode) {
        return new AstroSearch(
                astralBodyService.getAstralBodyById(astral),
                signService.getSignByZodiac(sign),
                houseService.getHouseByName(house),
                elementService.getElementById(element),
                modeService.getModeById(mode));
    }

}
