package com.smartfisherman.smartfishermansystem.sos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SosRepository 
        extends JpaRepository<SosRequest, Long> {


}