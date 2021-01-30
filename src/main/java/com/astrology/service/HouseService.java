package com.astrology.service;

import com.astrology.model.House;
import com.astrology.repo.HouseRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
public class HouseService {

    private House house;
    private HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public List<House> getAll() {
        return this.houseRepository.findAll();
    }

    public House getHouseByName(int house) {
        return this.houseRepository.findById(house).orElseThrow();
    }
}
