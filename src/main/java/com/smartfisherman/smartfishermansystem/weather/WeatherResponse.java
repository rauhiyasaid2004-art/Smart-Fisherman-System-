package com.smartfisherman.smartfishermansystem.weather;

public class WeatherResponse {

    private String city;
    private double temperature;
    private double humidity;
    private double windSpeed;
    private String condition;


    public WeatherResponse(){

    }


    public WeatherResponse(
            String city,
            double temperature,
            double humidity,
            double windSpeed,
            String condition){

        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.condition = condition;

    }


    public String getCity(){
        return city;
    }


    public double getTemperature(){
        return temperature;
    }


    public double getHumidity(){
        return humidity;
    }


    public double getWindSpeed(){
        return windSpeed;
    }


    public String getCondition(){
        return condition;
    }

}