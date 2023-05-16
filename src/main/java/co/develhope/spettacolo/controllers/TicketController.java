package co.develhope.spettacolo.controllers;

import co.develhope.spettacolo.entities.Posto;
import co.develhope.spettacolo.entities.Spettacolo;
import co.develhope.spettacolo.entities.Ticket;
import co.develhope.spettacolo.entities.Utente;
import co.develhope.spettacolo.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable long id){
        return ticketRepository.getReferenceById(id);
    }
    @GetMapping("/all")
    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

    @PostMapping("/create")
    public Ticket createTicket(@RequestBody Ticket ticket){
        return ticketRepository.saveAndFlush(ticket);
    }
    @DeleteMapping("/{id}")
    public void deleteTicketById(@PathVariable long id){
        ticketRepository.deleteById(id);
    }

    @PutMapping("/update")
    public Ticket updateTicket(@RequestBody Ticket ticket){
        return ticketRepository.saveAndFlush(ticket);
    }

    @Query("select ticket.id from ticket where ticket.spettacolo = :show")
    public List<Ticket> ticketShow(@Param("show") long idSpettacolo,@Param("seat") long idSeat){
        return ticketRepository.allTicketShow(idSpettacolo,idSeat);
    }
    public List<Ticket> ticketUserShow(long idSpettacolo,long idUser){
        return ticketRepository.allTicketsUserShow(idSpettacolo,idUser);
    }

}
