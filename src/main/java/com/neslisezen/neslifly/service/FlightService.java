package com.neslisezen.neslifly.service;

import com.neslisezen.neslifly.dto.request.FlightSaveRequest;
import com.neslisezen.neslifly.dto.response.FlightSaveResponse;
import com.neslisezen.neslifly.entity.Airport;
import com.neslisezen.neslifly.entity.Flight;
import com.neslisezen.neslifly.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;
    private final AirportService airportService;

    public List<Flight> getMyFlights() {
        return flightRepository.findAll();
    }
    @Transactional
    public FlightSaveResponse save(FlightSaveRequest flightSaveRequest) {

        var newFlight = Flight.builder()
                .airports(airportService.getAirportsByName(flightSaveRequest.getAirport_arr()
                        ,flightSaveRequest.getAirport_des()))
                .build();
        var savedFlight = flightRepository.save(newFlight);

        var response = FlightSaveResponse.builder()
                .flightNumber(savedFlight.getFlightNumber())
                .airports((ArrayList<Airport>) savedFlight.getAirports())
                .CAPACITY(savedFlight.getCAPACITY())
                .availability(savedFlight.getAvailability())
                .build();
        return response;
    }


}