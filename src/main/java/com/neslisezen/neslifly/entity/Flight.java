package com.neslisezen.neslifly.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "Flight")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Flight
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
  //  private Route route;
    @Column(name="Number",nullable = false,length = 50)
    private String flightNumber; //generate methode
    @OneToMany(fetch = FetchType.LAZY)
    private List<Airport> airports;

    @Column(name="Capacity",nullable = true,length = 50)
    private int CAPACITY;
    @Column(name="Taken",length = 10)
    private int availability = CAPACITY-(int) Math.random() * 10;

    public String getFlightNumber()
    {
        return generateFlightNumber();
    }
    private String generateFlightNumber()
    {
        return ""+id%10 + airports.get(0).getAbbr().substring(1,2)
                + Math.random()*10 + airports.get(1).getAbbr().substring(2,3)
                + CAPACITY / 2;
    }
}
