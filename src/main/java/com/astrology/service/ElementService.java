package com.astrology.service;

import com.astrology.model.Element;
import com.astrology.repo.ElementRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
public class ElementService {

    private ElementRepository elementRepository;

    public ElementService(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    public List<Element> getAll() {
        return this.elementRepository.findAll();
    }

    public Element getElementById(String element) {
        return this.elementRepository.findById(element).orElseThrow();
    }
}
