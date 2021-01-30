package com.astrology.service;


import com.astrology.model.Mode;
import com.astrology.repo.ModeRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
public class ModeService {

    private ModeRepository modeRepository;

    public ModeService(ModeRepository modeRepository) {
        this.modeRepository = modeRepository;
    }

    public List<Mode> getAll() {
        return this.modeRepository.findAll();
    }

    public Mode getModeById(String mode) {
        return this.modeRepository.findById(mode).orElseThrow();
    }


}
