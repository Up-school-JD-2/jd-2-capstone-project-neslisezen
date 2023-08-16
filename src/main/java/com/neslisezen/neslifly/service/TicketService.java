package com.neslisezen.neslifly.service;

import com.neslisezen.neslifly.dto.request.FlightSaveRequest;
import com.neslisezen.neslifly.dto.request.TicketSaveRequest;
import com.neslisezen.neslifly.dto.response.FlightSaveResponse;
import com.neslisezen.neslifly.dto.response.TicketSaveResponse;
import com.neslisezen.neslifly.entity.Airport;
import com.neslisezen.neslifly.entity.Flight;
import com.neslisezen.neslifly.entity.Ticket;
import com.neslisezen.neslifly.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketService
{
    private final TicketRepository ticketRepository;

    List<Ticket> findAll()
    {
        return ticketRepository.findAll()
                .stream()
                .filter(n -> n.getActive()==true)
                .collect(Collectors.toList());
    }
    public void delete(int id)
    {
        var ticket = ticketRepository.findById(id).get();
        ticket.setActive(false);
        ticketRepository.save(ticket);
    }
    @Transactional
    public TicketSaveResponse save(TicketSaveRequest ticketSaveRequest) {

        var newTicket = Ticket.builder()
                .active(true)
                .passenger(ticketSaveRequest.getPassenger())
                .flight(ticketSaveRequest.getFlight())
                .creditCard(ticketSaveRequest.maskedCard(ticketSaveRequest.getCreditCard()))
                .number(ticketSaveRequest.getNumber())
                .price(ticketSaveRequest.getPrice())
                .build();
        var savedTicket = ticketRepository.save(newTicket);

        var response = TicketSaveResponse.builder()
                .id(savedTicket.getId())
                .passenger(savedTicket.getPassenger())
                .flight(savedTicket.getFlight())
                .number(savedTicket.getNumber())
                .price(savedTicket.getPrice())
                .build();
        return response;
    }
    Ticket findTicketByNumber(String ticketNumber)
    {
        return ticketRepository.findTicketByNumber(ticketNumber);
    }
}
