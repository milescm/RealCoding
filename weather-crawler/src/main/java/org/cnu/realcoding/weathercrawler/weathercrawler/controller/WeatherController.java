package org.cnu.realcoding.weathercrawler.weathercrawler.controller;


import org.cnu.realcoding.weathercrawler.weathercrawler.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//RestController annoation 은 view를 return하지 않음
//일반 Controller annoation은 view 를 return
@RestController
public class WeatherController {


    @Autowired
    private WeatherService weatherService;

    @GetMapping("/available-cities")
    public List<String> getAvailableCities(){
        return weatherService.getAvailableCityNames();


    }

}
