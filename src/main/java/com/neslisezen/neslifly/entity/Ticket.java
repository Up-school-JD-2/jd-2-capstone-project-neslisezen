package com.neslisezen.neslifly.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Ticket")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket
{
    @Id
    @GeneratedValue
    private int id;
    @Column(name= "is_active",length = 10)
    private Boolean active = true;

    @Column(name = "Number",nullable = false,length = 50)
    private String number;

    @Column(name = "price",nullable = false,length = 10)
    private double price;

    @ManyToOne
    @JoinColumn(name = "Passenger",nullable = false)
    private Passenger passenger;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight" )
    private Flight flight;
    // with some info (const?)
    @Transient
    private String creditCard;



}
