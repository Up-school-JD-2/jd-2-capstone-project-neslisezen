package com.neslisezen.neslifly.controller;

import com.neslisezen.neslifly.dto.BaseResponse;
import com.neslisezen.neslifly.dto.request.TicketSaveRequest;
import com.neslisezen.neslifly.dto.response.AirportSaveResponse;
import com.neslisezen.neslifly.dto.response.TicketSaveResponse;
import com.neslisezen.neslifly.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/Ticket")
@Valid
public class TicketController
{
    public final TicketService ticketService;
    @DeleteMapping("{id}")
    public void deleteTicket(@PathVariable("id") int id){
        ticketService.delete(id); //soft delete
    }
    @PostMapping("/")
    public ResponseEntity<Object> createTicket(@Valid @RequestBody TicketSaveRequest ticketSaveRequest)
    {
        var ticketSaveResponse = ticketService.save(ticketSaveRequest);
        var response = BaseResponse.<TicketSaveResponse>builder()
                .status(HttpStatus.CREATED.value())
                .success(true)
                .data(ticketSaveResponse)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
