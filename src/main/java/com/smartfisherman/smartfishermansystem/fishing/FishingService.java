package com.smartfisherman.smartfishermansystem.fishing;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FishingService {


    private final FishingRepository fishingRepository;


    public FishingService(FishingRepository fishingRepository){

        this.fishingRepository = fishingRepository;

    }



    // SAVE LOCATION
    public FishingLocation saveLocation(FishingLocation location){

        return fishingRepository.save(location);

    }



    // GET ALL LOCATIONS
    public List<FishingLocation> getAllLocations(){

        return fishingRepository.findAll();

    }



    // GET LOCATION BY ID
    public Optional<FishingLocation> getLocationById(Long id){

        return fishingRepository.findById(id);

    }



    // DELETE LOCATION

    public void deleteLocation(Long id){

        fishingRepository.deleteById(id);

    }


}