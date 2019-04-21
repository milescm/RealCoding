package org.cnu.realcoding.weathercrawler.weathercrawler.service;


import org.cnu.realcoding.weathercrawler.weathercrawler.api.OpenWeatherMapApiClient;
import org.cnu.realcoding.weathercrawler.weathercrawler.domain.CurrentWeather;
import org.cnu.realcoding.weathercrawler.weathercrawler.repository.CurrentWeatherrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//ioc 개념
// 이 weatherservice객체를 사용하고 싶어지면 di 개념으로 선언하고 annotation넣으면 di개념으로
//container가 관리하고 있던 객체를 사용할 수 있게 된다.


@Service
public class WeatherService {



    @Autowired
    private OpenWeatherMapApiClient openWeatherMapApiClient;


    private LinkedList<String> cityNamesQueue = new LinkedList<>();

    @Autowired
    private AvailableCityNameService availableCityNameService;


    @Autowired
    private CurrentWeatherrepository currentWeatherRepository;


    private LinkedList<String> queue = new LinkedList<>();

    public List<String> getAvailableCityNames(){

        return availableCityNameService.getAvailableCityNames();
    }




    @Scheduled(initialDelay = 5000L, fixedDelay = 2000L)
    public void getCurrentWeatherPeriodically(){
        if(queue.isEmpty()){
            queue.addAll(this.getAvailableCityNames());
        }

        String target = queue.pop();
        queue.add(target);
        CurrentWeather currentWeather = openWeatherMapApiClient.getCurrentWeather(target);
        currentWeatherRepository.insertCurrentWeather(currentWeather);
    }








}
