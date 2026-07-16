package com.smartfisherman.smartfishermansystem.weather;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin("*")
public class WeatherController {


    private final WeatherService weatherService;


    public WeatherController(WeatherService weatherService){

        this.weatherService = weatherService;
    }


    @GetMapping("/{city}")
    public WeatherResponse getWeather(
            @PathVariable String city){

        return weatherService.getWeather(city);
    }

}