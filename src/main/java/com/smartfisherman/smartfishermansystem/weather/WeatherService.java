package com.smartfisherman.smartfishermansystem.weather;

import org.springframework.stereotype.Service;


@Service
public class WeatherService {


    public WeatherResponse getWeather(String city){


        return new WeatherResponse(
                city,
                28.5,
                76,
                12,
                "Cloudy"
        );

    }

}