package com.smartfisherman.smartfishermansystem.market;

import jakarta.persistence.*;

@Entity
@Table(name = "fish_prices")
public class FishPrice {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String fishName;


    private double price;


    private String market;



    public FishPrice(){

    }



    public FishPrice(
            String fishName,
            double price,
            String market
    ){

        this.fishName = fishName;
        this.price = price;
        this.market = market;

    }



    public Long getId(){

        return id;

    }



    public String getFishName(){

        return fishName;

    }



    public void setFishName(String fishName){

        this.fishName = fishName;

    }



    public double getPrice(){

        return price;

    }



    public void setPrice(double price){

        this.price = price;

    }



    public String getMarket(){

        return market;

    }



    public void setMarket(String market){

        this.market = market;

    }

}