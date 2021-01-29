package com.astrology.controller;

import com.astrology.model.Mode;
import com.astrology.repo.ModeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/modes")
public class ModeController {

    private ModeRepository modeRepository;

    public ModeController(ModeRepository modeRepository) {
        this.modeRepository = modeRepository;
    }

    @GetMapping("/all")
    public List<Mode> getAll() {
        return this.modeRepository.findAll();
    }
}
