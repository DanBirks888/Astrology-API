package com.astrology.controller;


import com.astrology.model.House;
import com.astrology.repo.HouseRepository;
import com.astrology.service.HouseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/houses")
public class HouseController {

   private HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/all")
    public List<House> getAll() {
        return this.houseService.getAll();
    }

    @GetMapping("/house/{house}")
    public House getHouseByName(@PathVariable("house") int house) {
        return this.houseService.getHouseByName(house);
    }

}
