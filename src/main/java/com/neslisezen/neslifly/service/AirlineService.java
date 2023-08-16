package com.neslisezen.neslifly.service;

import com.neslisezen.neslifly.dto.request.AirlineSaveRequest;
import com.neslisezen.neslifly.dto.response.AirlineSaveResponse;
import com.neslisezen.neslifly.entity.Airline;
import com.neslisezen.neslifly.repository.AirlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirlineService
{

    private final AirlineRepository airlineRepository;


    List<Airline> findAirlinesByNameContainingIgnoreCase(String name)
    {
        return airlineRepository.findAirlinesByNameContainingIgnoreCase(name);
    }

    public List<Airline> getAirlines()
    {
        return airlineRepository.findAll();
    }

    public AirlineSaveResponse save(AirlineSaveRequest airlineSaveRequest)
    {
        var newAirline = Airline.builder().name(airlineSaveRequest.getName()).build();
        var savedAirline = airlineRepository.save(newAirline);
        var response = AirlineSaveResponse.builder().name(savedAirline.getName()).build();
        return response;
    }
    public Airline save(Airline airline)
    {

        return airlineRepository.save(airline);
        //to create id for external use //from another repo

    }
    @Transactional
    public Airline getReferenceById(int id)
    {
        return airlineRepository.getReferenceById(id);
    }
    public void delete(int id)
    {
        airlineRepository.deleteById(id);
    }
}
