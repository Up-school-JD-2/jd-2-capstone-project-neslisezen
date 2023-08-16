package com.neslisezen.neslifly.repository;

import com.neslisezen.neslifly.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Integer>
{

}
