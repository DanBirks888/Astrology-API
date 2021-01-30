package com.astrology.service;

import com.astrology.model.House;
import com.astrology.model.Mode;
import com.astrology.model.Sign;
import com.astrology.repo.SignRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
public class SignService {

    private Sign sign;
    private SignRepository signRepository;

    public SignService(SignRepository signRepository) {
        this.signRepository = signRepository;
    }

    public List<Sign> getAll() {
        return this.signRepository.findAll();
    }

    public Sign getSignByZodiac(String zodiac) {
        return this.signRepository.findById(zodiac).orElseThrow();
    }

    public List<Sign> getSignByElement(String element) {
        return this.signRepository.findByElement(element);
    }

    public List<Mode> getSignByMode(String mode) {
        return this.signRepository.findByMode(mode);
    }

    public House getSignByHouse(int house) {
        return this.signRepository.findByHouse(house);
    }
}
