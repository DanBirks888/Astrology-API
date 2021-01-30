package com.astrology.repo;

import com.astrology.model.House;
import com.astrology.model.Mode;
import com.astrology.model.Sign;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignRepository extends MongoRepository<Sign, String> {
    List<Sign> findByElement(String element);

    List<Mode> findByMode(String mode);

    House findByHouse(int house);
}


