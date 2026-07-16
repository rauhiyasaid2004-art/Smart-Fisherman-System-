package com.smartfisherman.smartfishermansystem.fishing;

import jakarta.persistence.*;

@Entity
@Table(name = "fishing_locations")
public class FishingLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private double latitude;

    private double longitude;

    private String description;


    public FishingLocation(){

    }


    public FishingLocation(
            String name,
            double latitude,
            double longitude,
            String description
    ){

        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;

    }


    public Long getId(){
        return id;
    }


    public String getName(){
        return name;
    }


    public void setName(String name){
        this.name = name;
    }


    public double getLatitude(){
        return latitude;
    }


    public void setLatitude(double latitude){
        this.latitude = latitude;
    }


    public double getLongitude(){
        return longitude;
    }


    public void setLongitude(double longitude){
        this.longitude = longitude;
    }


    public String getDescription(){
        return description;
    }


    public void setDescription(String description){
        this.description = description;
    }

}