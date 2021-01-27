package com.astrology.repo;

import com.astrology.model.AstralBody;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AstroRepository extends MongoRepository<AstralBody, String> {
//    List<String> findBySingleLineMeaningById(String id);

}