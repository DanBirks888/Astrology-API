package com.astrology.controller;


import com.astrology.model.AstralBody;
import com.astrology.service.AstralBodyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/astrals")
public class AstralController {

    private AstralBodyService astralBodyService;

    public AstralController(AstralBodyService astralBodyService) {
        this.astralBodyService = astralBodyService;
    }

    @GetMapping("/bodies")
    public List<AstralBody> getAll() {
        return this.astralBodyService.getAll();
    }

    @GetMapping("/planet/{planet}")
    public AstralBody getPlanetById(@PathVariable("planet") String planet) {
        return this.astralBodyService.getAstralBodyById(planet);
    }

    @GetMapping("/oneLine/{oneLine}")
    public List<String> getWordMeaning(@PathVariable("oneLine") String oneLine) {
        return this.astralBodyService.singleLineMeaning(oneLine);
    }
}
