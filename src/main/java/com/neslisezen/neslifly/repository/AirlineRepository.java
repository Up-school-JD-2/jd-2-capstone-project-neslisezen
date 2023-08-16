package com.neslisezen.neslifly.repository;

import com.neslisezen.neslifly.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirlineRepository extends JpaRepository<Airline,Integer>
{
    List<Airline> findAirlinesByNameContainingIgnoreCase(String name);

}

