package co.develhope.spettacolo.repositories;


import co.develhope.spettacolo.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository  extends JpaRepository<Ticket,Long> {

    @Query(value = "select ticket.id from ticket where ticket.spettacolo =:show AND ticket.seat =:seat", nativeQuery = true)
    List<Ticket> allTicketShow(@Param("show") long idSpettacolo,@Param("seat") long idSeat);
    @Query(value = "select ticket.id from ticket where ticket.spettacolo =:show AND ticket.user = :user", nativeQuery = true)
    List<Ticket> allTicketsUserShow(@Param("show") long idSpettacolo,@Param("user") long idUser);
}
