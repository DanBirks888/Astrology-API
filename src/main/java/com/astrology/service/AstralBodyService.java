package com.astrology.service;

import com.astrology.model.AstralBody;
import com.astrology.repo.AstroRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Getter
@Setter
@Service
public class AstralBodyService {

    private AstralBody astralBody;
    private AstroRepository astroRepository;

    public AstralBodyService(AstroRepository astroRepository) {
        this.astroRepository = astroRepository;
    }

    public List<AstralBody> getAll() {
        return this.astroRepository.findAll();
    }

    public List<String> singleLineMeaning(String astralBody) {
        return astroRepository.findById(astralBody).get().getSingleLineMeaning();
    }

    public AstralBody getAstralBodyById(@PathVariable("planet") String planet) {
        return this.astroRepository.findById(planet).orElseThrow();
    }


}
