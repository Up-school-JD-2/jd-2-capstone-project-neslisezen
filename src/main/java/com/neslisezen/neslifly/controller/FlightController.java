package com.neslisezen.neslifly.controller;

import com.neslisezen.neslifly.dto.BaseResponse;
import com.neslisezen.neslifly.dto.request.AirportSaveRequest;
import com.neslisezen.neslifly.dto.request.FlightSaveRequest;
import com.neslisezen.neslifly.dto.response.AirportSaveResponse;
import com.neslisezen.neslifly.dto.response.FlightSaveResponse;
import com.neslisezen.neslifly.service.AirlineService;
import com.neslisezen.neslifly.service.FlightService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/Flight")
public class FlightController
{
    private final FlightService flightService;
    @PostMapping("/")
    @Transactional
    public ResponseEntity<Object> createFlight(@Valid @RequestBody FlightSaveRequest FlightSaveRequest)
    {
        var flightSaveResponse = flightService.save(FlightSaveRequest);
        var response = BaseResponse.<FlightSaveResponse>builder()
                .status(HttpStatus.CREATED.value())
                .success(true)
                .data(flightSaveResponse)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
