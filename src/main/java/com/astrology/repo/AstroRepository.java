package com.astrology.repo;

import com.astrology.model.AstralBody;
import com.astrology.service.AstralBodyService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AstroRepository extends MongoRepository<AstralBody, String> {
    List<String> singleLineMeaning(String name);
}