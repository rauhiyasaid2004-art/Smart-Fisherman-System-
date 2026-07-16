package com.smartfisherman.smartfishermansystem.market;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FishPriceService {


    private final FishPriceRepository fishPriceRepository;



    public FishPriceService(
            FishPriceRepository fishPriceRepository
    ){

        this.fishPriceRepository = fishPriceRepository;

    }




    // SAVE PRICE

    public FishPrice savePrice(FishPrice fishPrice){

        return fishPriceRepository.save(fishPrice);

    }




    // GET ALL PRICES

    public List<FishPrice> getAllPrices(){

        return fishPriceRepository.findAll();

    }




    // GET BY ID

    public Optional<FishPrice> getPriceById(Long id){

        return fishPriceRepository.findById(id);

    }




    // DELETE

    public void deletePrice(Long id){

        fishPriceRepository.deleteById(id);

    }


}