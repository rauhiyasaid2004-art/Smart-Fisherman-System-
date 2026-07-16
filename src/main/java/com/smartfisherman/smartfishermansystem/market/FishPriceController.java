package com.smartfisherman.smartfishermansystem.market;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/market")
@CrossOrigin("*")
public class FishPriceController {


    private final FishPriceService fishPriceService;



    public FishPriceController(
            FishPriceService fishPriceService
    ){

        this.fishPriceService = fishPriceService;

    }





    // CREATE FISH PRICE

    @PostMapping
    public FishPrice createPrice(
            @RequestBody FishPrice fishPrice
    ){

        return fishPriceService.savePrice(fishPrice);

    }





    // GET ALL

    @GetMapping
    public List<FishPrice> getAllPrices(){

        return fishPriceService.getAllPrices();

    }





    // GET BY ID

    @GetMapping("/{id}")
    public Optional<FishPrice> getPrice(
            @PathVariable Long id
    ){

        return fishPriceService.getPriceById(id);

    }





    // DELETE

    @DeleteMapping("/{id}")
    public String deletePrice(
            @PathVariable Long id
    ){

        fishPriceService.deletePrice(id);

        return "Fish price deleted successfully";

    }


}