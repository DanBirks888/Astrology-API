package com.astrology.controller;


import com.astrology.model.AstralBody;
import com.astrology.repo.AstroRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/astrals")
public class AstralController {

    private AstroRepository astroRepository;

    public AstralController(AstroRepository astroRepository) {
        this.astroRepository = astroRepository;
    }

    @GetMapping("/bodies")
    public List<AstralBody> getAll() {
        return this.astroRepository.findAll();
    }

    @GetMapping("/planet/{planet}")
    public AstralBody getPlanetById(@PathVariable("planet") String planet) {
        return this.astroRepository.findById(planet).orElseThrow();
    }

//    @GetMapping("/singleLineMeaning/{planet}")
//    public List<String> getSingleLineMeaningById(@PathVariable("planet") String planet) {
//        return this.astroRepository.findBySingleLineMeaningById(planet);
//    }
}
