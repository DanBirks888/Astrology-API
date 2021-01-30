package com.astrology.controller;

import com.astrology.service.CustomService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custom")
public class CustomController {

    private CustomService customService;

    public CustomController(CustomService customService) {
        this.customService = customService;
    }

//    @GetMapping("/body/sign/house/element/mode/{body}/{sign}/{house}/{element}/{mode}")
//    public AstroSearch getCustomAstroData(@PathVariable("body")String body,
//                                          @PathVariable("body")String sign,
//                                          @PathVariable("body")int house,
//                                          @PathVariable("body")String element,
//                                          @PathVariable("body")String mode
//                              ) {
//    return this.astrologyService.customAstroSearch(body, sign, house, element, mode);
//    }
}
