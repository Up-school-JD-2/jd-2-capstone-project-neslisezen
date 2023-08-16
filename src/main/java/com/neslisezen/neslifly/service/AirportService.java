package com.neslisezen.neslifly.service;


import com.neslisezen.neslifly.dto.request.AirportSaveRequest;
import com.neslisezen.neslifly.dto.response.AirportSaveResponse;
import com.neslisezen.neslifly.entity.Airport;
import com.neslisezen.neslifly.exception.NoSuchAirportException;
import com.neslisezen.neslifly.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AirportService
{
    private final AirportRepository airportRepository ;

    List<Airport> findAirportsByNameContainingIgnoreCase(String name)
    {
        return airportRepository.findAirportsByNameContainingIgnoreCase(name);
    }

    public List<Airport> getAirports()
{
    return airportRepository.findAll();
}

    public AirportSaveResponse save(AirportSaveRequest airportSaveRequest)
    {
        var newAirport = Airport.builder()
                .name(airportSaveRequest.getName())
                .city(airportSaveRequest.getCity())
                .abbr(airportSaveRequest.getAbbr())
                .build();
        var savedAirport = airportRepository.save(newAirport);

        var response = AirportSaveResponse.builder()
                .name(savedAirport.getName())
                .city(savedAirport.getCity())
                .abbr(savedAirport.getAbbr())
                .build();
        return response;
    }
    public Airport getAirportByName(String name)
    {
        Airport airportByName = airportRepository.getAirportByName(name);
        if(airportByName== null)
            throw new NoSuchAirportException("There is no such "+name+ " Airport! ");
        return airportByName;
    }
    public List<Airport> getAirportsByName(String name1, String name2)
    {
        Airport airportByName = airportRepository.getAirportByName(name1);
        Airport airportByName2 = airportRepository.getAirportByName(name2);
        if(airportByName== null)
            throw new NoSuchAirportException("There is no such "+name1+ " Airport! ");
        if(airportByName2== null)
            throw new NoSuchAirportException("There is no such "+name2+ " Airport! ");

        return List.of(airportByName, airportByName2);
    }
    public void delete(int id)
    {
        airportRepository.deleteById(id); //HARD DELETE
    }
}

