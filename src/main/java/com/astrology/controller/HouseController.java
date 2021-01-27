package com.astrology.controller;


import com.astrology.model.House;
import com.astrology.repo.HouseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/houses")
public class HouseController {

    private HouseRepository houseRepository;

    public HouseController(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @GetMapping("/all")
    public List<House> getAll() {
        return this.houseRepository.findAll();
    }

//    @GetMapping("/house/{house}")
//    public House getHouseByName(@PathVariable("house") int house) {
//        return this.houseRepository.findHouseById(house);
//    }

}
