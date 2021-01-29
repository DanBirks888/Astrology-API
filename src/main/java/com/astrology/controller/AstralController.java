package com.astrology.controller;


import com.astrology.model.AstralBody;
import com.astrology.repo.AstroRepository;
import com.astrology.service.AstralBodyService;
import com.astrology.service.AstrologyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/astrals")
public class AstralController {

    private AstroRepository astroRepository;
    private AstralBodyService astralBodyService;

    public AstralController(AstroRepository astroRepository, AstralBodyService astralBodyService) {
        this.astroRepository = astroRepository;
        this.astralBodyService = astralBodyService;
    }

    @GetMapping("/bodies")
    public List<AstralBody> getAll() {
        return this.astroRepository.findAll();
    }

    @GetMapping("/planet/{planet}")
    public AstralBody getPlanetById(@PathVariable("planet") String planet) {
        return this.astroRepository.findById(planet).orElseThrow();
    }

    @GetMapping("/astralBody/{astralBody}")
    public List<String> getWordMeaning(@PathVariable("astralBody") String astralBody) {
        return this.astralBodyService.singleLineMeaning(astralBody);
    }
}
