package com.smartfisherman.smartfishermansystem.fishing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishingRepository extends JpaRepository<FishingLocation, Long> {

}