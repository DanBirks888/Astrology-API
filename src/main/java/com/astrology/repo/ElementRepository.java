package com.astrology.repo;

import com.astrology.model.Element;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementRepository extends MongoRepository<Element, String> {
}
