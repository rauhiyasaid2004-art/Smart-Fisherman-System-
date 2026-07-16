package com.smartfisherman.smartfishermansystem.sos;

import jakarta.persistence.*;

@Entity
@Table(name = "sos_requests")
public class SosRequest {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    private String phone;


    private double latitude;


    private double longitude;


    private String message;


    private String status;



    public SosRequest(){

    }



    public SosRequest(
            String name,
            String phone,
            double latitude,
            double longitude,
            String message
    ){

        this.name = name;
        this.phone = phone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.message = message;
        this.status = "ACTIVE";

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



    public String getPhone(){

        return phone;

    }


    public void setPhone(String phone){

        this.phone = phone;

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



    public String getMessage(){

        return message;

    }


    public void setMessage(String message){

        this.message = message;

    }



    public String getStatus(){

        return status;

    }


    public void setStatus(String status){

        this.status = status;

    }

}