package com.astrology.repo;

import com.astrology.model.Mode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeRepository extends MongoRepository<Mode, String> {
}
