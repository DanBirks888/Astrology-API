package com.astrology.controller;

import com.astrology.model.Element;
import com.astrology.repo.ElementRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/elements")
public class ElementController {

    private ElementRepository elementRepository;

    public ElementController(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    @GetMapping("/all")
    public List<Element> getAll() {
        return this.elementRepository.findAll();
    }
}
