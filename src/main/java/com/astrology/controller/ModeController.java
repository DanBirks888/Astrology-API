package com.astrology.controller;

import com.astrology.model.Mode;
import com.astrology.service.ModeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/modes")
public class ModeController {

    private ModeService modeService;

    public ModeController(ModeService modeService) {
        this.modeService = modeService;
    }

    @GetMapping("/all")
    public List<Mode> getAll() {
        return this.modeService.getAll();
    }

    @GetMapping("/mode/{mode}")
    public Mode getModeById(@PathVariable("mode") String mode) {
        return this.modeService.getModeById(mode);
    }
}
