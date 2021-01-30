package com.astrology.controller;

import com.astrology.model.Element;
import com.astrology.repo.ElementRepository;
import com.astrology.service.ElementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/elements")
public class ElementController {

    private ElementService elementService;

    public ElementController(ElementService elementService) {
        this.elementService = elementService;
    }

    @GetMapping("/all")
    public List<Element> getAll() {
        return this.elementService.getAll();
    }

    @GetMapping("/element/{element}")
    public Element getElementById(String element) {
        return this.elementService.getElementById(element);
    }
}
