package com.astrology.service;

import com.astrology.model.AstralBody;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
public class AstralBodyService {

    private AstralBody astralBody;

    public AstralBodyService(AstralBody astralBody) {
        this.astralBody = astralBody;
    }

    public List<String> singleLineMeaning() {
        return astralBody.getSingleLineMeaning();
    }
}
