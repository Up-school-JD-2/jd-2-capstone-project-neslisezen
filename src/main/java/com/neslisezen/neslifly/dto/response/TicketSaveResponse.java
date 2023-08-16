package com.neslisezen.neslifly.dto.response;

import com.neslisezen.neslifly.entity.Flight;
import com.neslisezen.neslifly.entity.Passenger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketSaveResponse
{
    private int id;
    private String number;

    private double price;

    private Passenger passenger;

    private Flight flight;
}
