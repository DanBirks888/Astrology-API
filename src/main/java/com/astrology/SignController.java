package com.astrology;

import com.astrology.model.Sign;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/signs")
public class SignController {

    private SignRepository signRepository;

    public SignController(SignRepository signRepository) {
        this.signRepository = signRepository;
    }

    public List<Sign> getAll() {
        List<Sign> signs = this.signRepository.findAll();

        return signs;
    }

}
