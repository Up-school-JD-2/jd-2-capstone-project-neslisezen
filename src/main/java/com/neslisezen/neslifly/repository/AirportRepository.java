package com.neslisezen.neslifly.repository;

import com.neslisezen.neslifly.entity.Airline;
import com.neslisezen.neslifly.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Integer>
{
    List<Airport> findAirportsByNameContainingIgnoreCase(String name);
    @Query("SELECT a FROM Airport a WHERE a.name = :name")
    Airport getAirportByName(@Param("name")String name);

}
