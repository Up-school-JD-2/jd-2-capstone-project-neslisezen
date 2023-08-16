package com.neslisezen.neslifly.controller;

import com.neslisezen.neslifly.dto.request.AirlineSaveRequest;
import com.neslisezen.neslifly.dto.response.AirlineSaveResponse;
import com.neslisezen.neslifly.dto.BaseResponse;
import com.neslisezen.neslifly.entity.Airline;
import com.neslisezen.neslifly.service.AirlineService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/Airlines")
public class AirlineController

{
//    private final FlightService flightService;
    private final AirlineService airlineService;
    @PostConstruct
    //TEST
    public void init(){
        createAirline(new AirlineSaveRequest("Anadolu Jet"));
        createAirline(new AirlineSaveRequest("Emirates"));
        createAirline(new AirlineSaveRequest("Ryanair"));
        createAirline(new AirlineSaveRequest("Lufthansa"));
        createAirline(new AirlineSaveRequest("Pegasus"));
        createAirline(new AirlineSaveRequest("Qatar"));
        createAirline(new AirlineSaveRequest("Turk Hava Yolları"));
        createAirline(new AirlineSaveRequest("Corendon"));
        //test with Sunexpress for Postman
    }
    @GetMapping(("/"))
    public ResponseEntity<List<Airline>> getAirlines()
    {
     var airlines = airlineService.getAirlines();
     return ResponseEntity.status(HttpStatus.OK).body(airlines);
    }

   @PostMapping("/")
   public ResponseEntity<Object> createAirline(@Valid @RequestBody AirlineSaveRequest airlineSaveRequest)
   {
       var airlineSaveResponse = airlineService.save(airlineSaveRequest);
       var response = BaseResponse.<AirlineSaveResponse>builder()
               .status(HttpStatus.CREATED.value())
               .success(true)
               .data(airlineSaveResponse)
               .build();

       return ResponseEntity.status(HttpStatus.OK).body(response);
   }

   @DeleteMapping("{id}")
    public void deleteAirline(@PathVariable("id") int id)
   {
        airlineService.delete(id); //hard-delete
   }

 }
