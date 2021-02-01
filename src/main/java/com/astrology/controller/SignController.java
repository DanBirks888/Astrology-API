package com.astrology.controller;

import com.astrology.model.Mode;
import com.astrology.model.Sign;
import com.astrology.service.SignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/signs")
public class SignController {

    private SignService signService;

    public SignController(SignService signService) {
        this.signService = signService;
    }

    @GetMapping("/all")
    public List<Sign> getAll() {
        return this.signService.getAll();
    }

    @GetMapping("/zodiac/{zodiac}")
    public Sign getSignByZodiac(@PathVariable("zodiac") String zodiac) {
        return this.signService.getSignByZodiac(zodiac);
    }

    @GetMapping("/element/{element}")
    public List<Sign> getSignByElement(@PathVariable("element") String element) {
        return this.signService.getSignByElement(element);
    }

    @GetMapping("mode/{mode}")
    public List<Mode> getSignByMode(@PathVariable("mode") String mode) {
        return this.signService.getSignByMode(mode);
    }

    @GetMapping("house/{house}")
    public Sign getSignByHouse(@PathVariable("house") int house) {
        return this.signService.getSignByHouse(house);
    }

}
