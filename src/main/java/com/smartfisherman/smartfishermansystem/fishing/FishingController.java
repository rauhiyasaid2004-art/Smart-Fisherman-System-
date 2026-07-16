package com.smartfisherman.smartfishermansystem.fishing;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/fishing")
@CrossOrigin("*")
public class FishingController {


    private final FishingService fishingService;


    public FishingController(FishingService fishingService){

        this.fishingService = fishingService;

    }



    // CREATE FISHING LOCATION

    @PostMapping
    public FishingLocation createLocation(
            @RequestBody FishingLocation location
    ){

        return fishingService.saveLocation(location);

    }




    // GET ALL LOCATIONS

    @GetMapping
    public List<FishingLocation> getLocations(){

        return fishingService.getAllLocations();

    }





    // GET BY ID

    @GetMapping("/{id}")
    public Optional<FishingLocation> getLocation(
            @PathVariable Long id
    ){

        return fishingService.getLocationById(id);

    }





    // DELETE

    @DeleteMapping("/{id}")
    public String deleteLocation(
            @PathVariable Long id
    ){

        fishingService.deleteLocation(id);

        return "Fishing location deleted successfully";

    }


}