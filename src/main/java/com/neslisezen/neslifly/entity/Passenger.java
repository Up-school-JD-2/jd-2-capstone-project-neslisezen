package com.neslisezen.neslifly.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name = "Passenger")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Passenger
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name",nullable = false,length = 50)
    private String name;
    @Column(name = "Surname",nullable = false,length = 50)
    private String surname;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "Tickets",nullable = false)
    private List<Ticket> tickets;
}
//,mappedBy = "Passenger"