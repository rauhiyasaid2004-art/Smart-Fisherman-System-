package com.smartfisherman.smartfishermansystem.sos;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/sos")
@CrossOrigin("*")
public class SosController {



    private final SosService sosService;



    public SosController(SosService sosService){

        this.sosService = sosService;

    }




    // SEND SOS

    @PostMapping
    public SosRequest sendSOS(
            @RequestBody SosRequest request
    ){

        return sosService.saveRequest(request);

    }




    // GET ALL SOS

    @GetMapping
    public List<SosRequest> getAllSOS(){

        return sosService.getAllRequests();

    }





    // GET SOS BY ID

    @GetMapping("/{id}")
    public Optional<SosRequest> getSOS(
            @PathVariable Long id
    ){

        return sosService.getRequestById(id);

    }





    // DELETE SOS

    @DeleteMapping("/{id}")
    public String deleteSOS(
            @PathVariable Long id
    ){

        sosService.deleteRequest(id);

        return "SOS deleted successfully";

    }

}