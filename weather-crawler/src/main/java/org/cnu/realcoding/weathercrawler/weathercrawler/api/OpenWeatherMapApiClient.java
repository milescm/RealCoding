package org.cnu.realcoding.weathercrawler.weathercrawler.api;


import org.cnu.realcoding.weathercrawler.weathercrawler.domain.CurrentWeather;
import org.omg.CORBA.Current;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherMapApiClient {

    private String requestUrl = "https://api.openweathermap.org/data/2.5/weather?q={cityName}&appid={apiKey}";


    @Autowired
    private RestTemplate restTemplate;


    //여기 메소드 exchange대신 get으로 바꿔서 연습해보기
    public CurrentWeather getCurrentWeather(String cityName){
     return restTemplate.exchange(requestUrl, HttpMethod.GET, null, CurrentWeather.class, cityName, "28685b8f7e2efab4477be330b1bffd15").getBody();
    }



}
