package com.astrology;

import com.astrology.model.AstralBody;
import com.astrology.model.Sign;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/signs")
public class SignController {

    private PlanetRepository planetRepository;

    public SignController(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public List<Sign> getAll() {
        List<Sign> signs = this.planetRepository.findAll();

        return signs;
    }

}
