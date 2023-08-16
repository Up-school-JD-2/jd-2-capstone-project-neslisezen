package com.neslisezen.neslifly.repository;

import com.neslisezen.neslifly.entity.Ticket;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Where(clause= "is_active = true")
@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer>
{
    Ticket findTicketByNumber(String ticketNumber);
}
