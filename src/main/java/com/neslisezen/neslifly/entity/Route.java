package com.neslisezen.neslifly.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Route")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Route
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "departure")
    private String departure;

    @Column(name = "destination")
    private String destination;

}
