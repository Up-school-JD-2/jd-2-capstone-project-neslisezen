package com.neslisezen.neslifly.dto.response;
import com.neslisezen.neslifly.entity.Airport;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightSaveResponse
{
    private int id;
    private String flightNumber; //generate methode

    private ArrayList<Airport> airports;

    private int CAPACITY;

    private int availability;
}
