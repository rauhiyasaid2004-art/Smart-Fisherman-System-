package com.smartfisherman.smartfishermansystem.sos;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class SosService {


    private final SosRepository sosRepository;



    public SosService(SosRepository sosRepository){

        this.sosRepository = sosRepository;

    }



    // CREATE SOS

    public SosRequest saveRequest(SosRequest request){

        request.setStatus("ACTIVE");

        return sosRepository.save(request);

    }



    // GET ALL SOS

    public List<SosRequest> getAllRequests(){

        return sosRepository.findAll();

    }



    // GET BY ID

    public Optional<SosRequest> getRequestById(Long id){

        return sosRepository.findById(id);

    }



    // DELETE

    public void deleteRequest(Long id){

        sosRepository.deleteById(id);

    }


}