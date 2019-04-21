package org.cnu.realcoding.weathercrawler.weathercrawler.repository;


import org.cnu.realcoding.weathercrawler.weathercrawler.domain.CurrentWeather;
import org.omg.CORBA.Current;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CurrentWeatherrepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public CurrentWeather insertCurrentWeather(CurrentWeather currentWeather){
   return  mongoTemplate.insert(currentWeather);
    }


}
