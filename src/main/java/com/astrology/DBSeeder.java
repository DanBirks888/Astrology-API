package com.astrology;

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

    @Value("classpath:AstrologyPlanets.json")
    private Resource planets;
    private PlanetRepository planetRepository;
    private ObjectMapper objectMapper;

    public DBSeeder(PlanetRepository planetRepository, ObjectMapper objectMapper) {
        this.planetRepository = planetRepository;
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {

        List<Planet> planets1 = objectMapper.readValue(planets.getInputStream(), new TypeReference<List<Planet>>() {
        });
        this.planetRepository.deleteAll();
        this.planetRepository.saveAll(planets1);
    }
}