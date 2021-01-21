package com.astrology;

import com.astrology.model.*;
import com.astrology.repo.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBSeeder implements ApplicationListener<ApplicationReadyEvent> {

    @Value("classpath:signs.json")
    private Resource signs;
    @Value("classpath:astralBodies.json")
    private Resource astralBodies;
    @Value("classpath:elements.json")
    private Resource elements;
    @Value("classpath:houses.json")
    private Resource houses;
    @Value("classpath:modes.json")
    private Resource modes;

    private SignRepository signRepository;
    private AstroRepository astroRepository;
    private HouseRepository houseRepository;
    private ElementRepository elementRepository;
    private ModeRepository modeRepository;
    private ObjectMapper objectMapper;

    public DBSeeder(SignRepository signRepository, AstroRepository astroRepository, HouseRepository houseRepository, ElementRepository elementRepository, ModeRepository modeRepository, ObjectMapper objectMapper) {
        this.signRepository = signRepository;
        this.astroRepository = astroRepository;
        this.houseRepository = houseRepository;
        this.elementRepository = elementRepository;
        this.modeRepository = modeRepository;
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {

        List<Sign> signsDb = objectMapper.readValue(signs.getInputStream(), new TypeReference<List<Sign>>() {
        });
        this.signRepository.deleteAll();
        this.signRepository.saveAll(signsDb);

        List<AstralBody> astralBodiesDb = objectMapper.readValue(astralBodies.getInputStream(), new TypeReference<List<AstralBody>>() {
        });
        this.astroRepository.deleteAll();
        this.astroRepository.saveAll(astralBodiesDb);

        List<House> houseDb = objectMapper.readValue(houses.getInputStream(), new TypeReference<List<House>>() {
        });
        this.houseRepository.deleteAll();
        this.houseRepository.saveAll(houseDb);

        List<Element> elementsDb = objectMapper.readValue(elements.getInputStream(), new TypeReference<List<Element>>() {
        });
        this.elementRepository.deleteAll();
        this.elementRepository.saveAll(elementsDb);

        List<Mode> modeDb = objectMapper.readValue(modes.getInputStream(), new TypeReference<List<Mode>>() {
        });
        this.modeRepository.deleteAll();
        this.modeRepository.saveAll(modeDb);
    }
}