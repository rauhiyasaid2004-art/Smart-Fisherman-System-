package com.smartfisherman.smartfishermansystem.market;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FishPriceRepository 
        extends JpaRepository<FishPrice, Long> {


}