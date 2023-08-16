package com.neslisezen.neslifly.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Entity
@Table(name = "Airport")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class Airport
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="airport",nullable = false, length =100)
    private String name;

    @Column(name = "City",nullable = false)
    private String city;
    //assumption: every city has just one airport***

    @Column(name = "Code",nullable = true,length = 5)
    private String abbr; //Abbreviation
}
