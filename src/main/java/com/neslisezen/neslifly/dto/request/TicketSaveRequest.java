package com.neslisezen.neslifly.dto.request;

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
public class TicketSaveRequest
{
    private Passenger passenger;

    private Flight flight;

    private String creditCard;
    private String generateTicketNumber()
    {
        String ticketNumber = flight.getAirports().get(0)
                +Double.toString(Math.random() * 37 + 1)
                + flight.getAirports().get(1)
                + Double.toString(Math.random() * 17 + 1);
        return ticketNumber;
    }
    private double generatePrice()
    {
        return Math.random() * 200 + 1;
    }
    public String maskedCard(String card)
    {
        String Card = card.replaceAll("\\s+","");
        if(Card.contains("-"))
            Card.replace("-","");
        if(Card.contains(","))
            Card.replace(",","");
        if(Card.contains("."))
            Card.replace(".","");

        return ""+Card.substring(0,4)+ "********"+Card.substring(12,16);

    }
    public String getNumber()
    {
        return generateTicketNumber();
    }
    public double getPrice()
    {
        return generatePrice();
    }
}
