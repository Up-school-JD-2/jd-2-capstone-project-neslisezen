package com.neslisezen.neslifly.controller;

import com.neslisezen.neslifly.dto.BaseResponse;
import com.neslisezen.neslifly.dto.request.AirlineSaveRequest;
import com.neslisezen.neslifly.dto.request.AirportSaveRequest;
import com.neslisezen.neslifly.dto.response.AirlineSaveResponse;
import com.neslisezen.neslifly.dto.response.AirportSaveResponse;
import com.neslisezen.neslifly.entity.Airport;
import com.neslisezen.neslifly.service.AirportService;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/Airports")
public class AirportController
{
    private final AirportService airportService;
    @PostConstruct()
    //TEST
    public void init(){
        createAirport(new AirportSaveRequest("Istanbul Airport","Istanbul","IST"));
        createAirport(new AirportSaveRequest("Konya Airport","Konya","KYA"));
        createAirport(new AirportSaveRequest("Antalya Airport","Istanbul","AYT"));
        createAirport(new AirportSaveRequest("Adnan Menderes Airport","Izmir","ADB"));
        createAirport(new AirportSaveRequest("Adana Airport","Adana","ADA"));
        createAirport(new AirportSaveRequest("Hatay","Hatay","HTY"));
        //test with Erzurum Airport ERZ for Postman
    }

    @PostMapping("/")
    public ResponseEntity<Object> createAirport(@Valid @RequestBody AirportSaveRequest airportSaveRequest)
    {
        var airportSaveResponse = airportService.save(airportSaveRequest);
        var response = BaseResponse.<AirportSaveResponse>builder()
                .status(HttpStatus.CREATED.value())
                .success(true)
                .data(airportSaveResponse)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
